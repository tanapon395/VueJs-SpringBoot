import Vue from 'vue'
import Router from 'vue-router';
import ViewRental from '../components/ViewRentalData';
import VideoRental from '../components/VideoRental';

Vue.use(Router);

export default new Router({
    mode: 'history',
    base: process.env.BASE_URL,
    routes: [{
            path: '/',
            component: VideoRental
        },
        {
            path: '/view',
            component: ViewRental
        }
    ]
});