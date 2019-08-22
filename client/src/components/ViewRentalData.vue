<template>
  <v-container>
    <v-layout text-center wrap>
      <v-flex mb-4>
        <br />
        <h1 class="display-2 font-weight-bold mb-3">Video Rental Information</h1>
      </v-flex>
    </v-layout>

    <v-row justify="center">
      <v-col cols="8">
        <v-data-table :headers="headers" :items="items" :items-per-page="5" class="elevation-1">
        </v-data-table>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import http from "../http-common";

export default {
  name: "ViewRentalData",
  data() {
    return {
      headers: [
        {
          text: "Customer",
          align: "left",
          sortable: false,
          value: "rentCustomer.name"
        },
        { text: "Employee", value: "createdBy.name" },
        { text: "RentalType", value: "type.name" },
        { text: "Video", value: "video.title" }
      ],
      items: []
    };
  },
  methods: {
    /* eslint-disable no-console */
    // ดึงข้อมูล VideoRental ใส่ combobox
    getVideoRentals() {
      http
        .get("/videoRental")
        .then(response => {
          this.items = response.data;
          console.log(this.items);
        })
        .catch(e => {
          console.log(e);
        });
    },
    refreshList() {
      this.getVideoRentals();
    }
    /* eslint-disable no-console */
  },
  mounted() {
    this.getVideoRentals();
  }
};
</script>
