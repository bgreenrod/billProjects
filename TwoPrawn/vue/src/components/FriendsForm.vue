<template>
<form v-on:submit="addNewFriend">
    <div class="friend-form">
        <h3 class="friend-head">Add a Friend!</h3>
        <label for="firstname">First Name:</label>
        <input id="firstname" type="text" v-model="newFriend.friend_first_name">  
    
        <label for="lastname">Last Name:</label>
        <input id="lastname" type="text" v-model="newFriend.friend_last_name">  
    
        <label for="email">Email address:</label>
        <input id="email" type="email" v-model="newFriend.friend_email_address">   
    <div class="buttons">
    <input class="submitbtn" type="submit" value="Save" />
    <input class="cancelbtn" type="button" value="Clear" @click="cancelForm"/>
    </div>
    <p id="done">Done adding  friends? <router-link :to="{path: '/'}">Click Me!</router-link></p>
</div>
</form>

</template>

<script>
import FriendService from '../services/FriendService';
export default {
    props: {
        friend: {
          type: Object,
        required: true  
        }
    },
    data(){
        return {
            newFriend: {
                friend_first_name: "",
                friend_last_name: "",
                friend_email_address: ""
        },
            friendsArray: [],
        };
    },
    methods: {
        addNewFriend(){
            this.friendsArray.push(this.newFriend)
            FriendService.addFriend(this.friendsArray);
            this.resetForm();
        },
        cancelForm(){
            this.$emit('cancel');
            this.resetForm();
        },
        resetForm(){
            this.newFriend = {};
        }
    }
}
</script>

<style scoped>
.friend-form {
    font-family: quicksand;
    font-variant: small-caps;
    font-weight: 600;
    display: flex;
    flex-direction: column;
    border-radius: 15px;
    border: 4px solid rgb(255,127,80);
    padding: 5px;
    width: 15vw;
    background-color: rgb(252,191,188)
}
#email {
    margin-bottom: 5px;
}
.buttons {
    display: flex;
    flex-direction: row;
    justify-content: space-evenly;
}
#done {
    text-align: flex-start;
    font-size: larger;
    
}
</style>
