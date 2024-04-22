<template>
<div class="friend-view">
    <!-- <h1 class="friend-head">Friends List</h1> -->
    <!-- <button class="add-friend" v-on:click="toggleFriendsForm">Add a New Friend</button> -->

    <FriendsForm id='add-friend' v-bind:friend="friend" />
    <FriendsList id='friend-list' :friends="friends"/>
</div>
</template>

<script>
import FriendService from '../services/FriendService';
import FriendsForm from '../components/FriendsForm.vue';
import FriendsList from '../components/FriendsList.vue';

export default {
    components: {
        FriendsForm,
        FriendsList
    },
    data() {
        return {
            friends: [],
            friend: {
                friend_first_name: "",
                friend_last_name: "",
                friend_email_address: "",
            },
            showForm: false
        };
    },
    methods: {
        getFriendsList() {
            FriendService.friendsList()
            .then(response => {
                this.friends = response.data;
            })
        },
        toggleFriendsForm(){
            this.showForm = !this.showForm;
        }
    }
}
</script>



<style>
.friend-view {
    font-family: quicksand;
    font-variant: small-caps;
    font-size: larger;
    font-weight: 600;
    text-align: center;
    margin-top: 10vh;
    display: flex;
    flex-direction: row;
    margin-left: 20%;
    justify-content: flex-start;
    height: 100vh; 
}


</style>