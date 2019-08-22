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
          <v-switch v-model="customerCheck" class="ma-2" label="Ediatable"></v-switch>
          <v-text-field
            outlined
            label="Customer ID"
            v-model="videoRental.customerId"
            :rules="[(v) => !!v || 'Item is required']"
            required
          ></v-text-field>
          <div v-if="customerCheck">
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
            <br />
            <p style="text-align:center">
              <v-btn @click="saveVideoRental" :class="{ red: !valid, green: valid }">submit</v-btn>
            </p>
          </div>
        </v-form>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import http from "../http-common";

export default {
  name : 'videoRental',
  data() {
    return {
      videoRental: {
        customerId: "",
        employeeId: "",
        rentalId: "",
        videoId: ""
      },
      valid: false,
      customerCheck: false
    };
  },
  methods: {
    /* eslint-disable no-console */
    // ดึงข้อมูล Customer
    // getCustomers() {
    //   http
    //     .get("/customer")
    //     .then(response => {
    //       this.customers = response.data;
    //       console.log(response.data);
    //     })
    //     .catch(e => {
    //       console.log(e);
    //     });
    // },
    // ดึงข้อมูล Employee
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
    // ดึงข้อมูล Video
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
    // ดึงข้อมูล RentalType
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
    // function เมื่อกดปุ่ม submit
    saveVideoRental() {
      console.log(this.videoRental);
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
        })
        .catch(e => {
          console.log(e);
        });
      this.submitted = true;
    },
    refreshList() {
      this.getCustomers();
      this.getEmployees();
      this.getVideos();
      this.getRentalTypes();
    }
    /* eslint-enable no-console */
  },
  mounted() {
    // this.getCustomers();
    this.getEmployees();
    this.getVideos();
    this.getRentalTypes();
  }
};
</script>
