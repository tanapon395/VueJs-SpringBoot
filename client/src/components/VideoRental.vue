<template>
  <v-container>
    <v-layout text-center wrap>
      <v-flex mb-4>
        <br />
        <h1 class="display-2 font-weight-bold mb-3">Welcome to VideoRental</h1>
      </v-flex>
    </v-layout>

    <v-row justify="center">
      <v-col cols="4">
        <v-form v-model="valid" ref="form">
          <v-row justify="center">
            <v-col cols="10">
              <v-text-field
                outlined
                label="Customer ID"
                v-model="videoRental.customerId"
                :rules="[(v) => !!v || 'Item is required']"
                required
              ></v-text-field>
              <p v-if="customerCheck != ''">Customer Name : {{customerName}}</p>
            </v-col>
            <v-col cols="2">
              <div class="my-2">
                <v-btn @click="findCustomer" depressed large color="primary">Search</v-btn>
              </div>
            </v-col>
          </v-row>

          <div v-if="customerCheck">
            <v-row>
              <v-col cols="10">
                <v-select
                  label="Employee"
                  outlined
                  v-model="videoRental.employeeId"
                  :items="employees"
                  item-text="name"
                  item-value="id"
                  :rules="[(v) => !!v || 'Item is required']"
                  required
                ></v-select>
              </v-col>
            </v-row>
            <v-row>
              <v-col cols="10">
                <v-select
                  label="RentalType"
                  outlined
                  v-model="videoRental.rentalId"
                  :items="rentalTypes"
                  item-text="name"
                  item-value="id"
                  :rules="[(v) => !!v || 'Item is required']"
                  required
                ></v-select>
              </v-col>
            </v-row>
            <v-row>
              <v-col cols="10">
                <v-select
                  label="Video"
                  outlined
                  v-model="videoRental.videoId"
                  :items="videos"
                  item-text="title"
                  item-value="id"
                  :rules="[(v) => !!v || 'Item is required']"
                  required
                ></v-select>
              </v-col>
            </v-row>
            <v-row justify="center">
              <v-col cols="12">
                <v-btn @click="saveVideoRental" :class="{ red: !valid, green: valid }">submit</v-btn>
                <v-btn style="margin-left: 15px;" @click="clear">clear</v-btn>
              </v-col>
            </v-row>
            <br />
          </div>
        </v-form>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import http from "../http-common";

export default {
  name: "videoRental",
  data() {
    return {
      videoRental: {
        customerId: "",
        employeeId: "",
        rentalId: "",
        videoId: ""
      },
      valid: false,
      customerCheck: false,
      customerName: ""
    };
  },
  methods: {
    /* eslint-disable no-console */

    // ดึงข้อมูล Employee ใส่ combobox
    getEmployees() {
      http
        .get("/employee")
        .then(response => {
          this.employees = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
    // ดึงข้อมูล Video ใส่ combobox
    getVideos() {
      http
        .get("/video")
        .then(response => {
          this.videos = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
    // ดึงข้อมูล RentalType ใส่ combobox
    getRentalTypes() {
      http
        .get("/rentalType")
        .then(response => {
          this.rentalTypes = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
    // function ค้นหาลูกค้าด้วย ID
    findCustomer() {
      http
        .get("/customer/" + this.videoRental.customerId)
        .then(response => {
          console.log(response);
          if (response.data != null) {
            this.customerName = response.data.name;
            this.customerCheck = response.status;
          } else {
            this.clear()
          }          
        })
        .catch(e => {
          console.log(e);
        });
      this.submitted = true;
    },
    // function เมื่อกดปุ่ม submit
    saveVideoRental() {
      http
        .post(
          "/videoRental/" +
            this.videoRental.customerId +
            "/" +
            this.videoRental.employeeId +
            "/" +
            this.videoRental.videoId +
            "/" +
            this.videoRental.rentalId,
          this.videoRental
        )
        .then(response => {
          console.log(response);
          this.$router.push("/view");
        })
        .catch(e => {
          console.log(e);
        });
      this.submitted = true;
    },
    clear() {
      this.$refs.form.reset();
      this.customerCheck = false;
    },
    refreshList() {
      this.getEmployees();
      this.getVideos();
      this.getRentalTypes();
    }
    /* eslint-enable no-console */
  },
  mounted() {
    this.getEmployees();
    this.getVideos();
    this.getRentalTypes();
  }
};
</script>
