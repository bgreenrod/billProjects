<template>
    <div class="guest-view">
        <GuestForm v-bind:guest="guest" />
        
        <!-- <div id="guest-list">
            <h2>Guest List</h2>
        <GuestList />
        </div> -->
    </div>
</template>

<script>
import GuestForm from '../components/GuestForm.vue';
import GuestList from '../components/GuestList.vue';
export default {
    components: {
        // GuestList,
        GuestForm
    },
    data () {
        return {
            guest: {
                guest_first_name: "",
                guest_last_name: "",
                guest_email_address: "",
                potluck_id: this.$route.params.potluckId
            },
        }
    }
};
</script>

<style>
.guest-view {
    margin-top: 10vh;
    display: flex;
    flex-direction: row;
    margin-left: 20%;
    justify-content: flex-start;
    height: 100vh; 
}

</style>