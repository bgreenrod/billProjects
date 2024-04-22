<template>
    <form v-on:submit="addNewGuest">
        <div class="guest-form">
            <h3 id="form-head">Add a Guest!</h3>
            <label for="firstname">First Name</label>
            <input id="firstname" type="text" v-model="newGuest.guest_first_name">  
        
            <label for="lastname">Last Name</label>
            <input id="lastname" type="text" v-model="newGuest.guest_last_name">  
        
            <label for="email">Email Address</label>
            <input id="email" type="email" v-model="newGuest.guest_email_address">   
        
        <div class="buttons">
        <input class="submitbtn" type="submit" value="Save" />
        <input class="cancelbtn" type="button" value="Clear" @click="cancelForm"/>
        </div>
        <p id="done">Done adding your guests? <router-link :to="{name: 'PotluckView', params: {potluckId: $route.params.potluckId}}">Click Me!</router-link></p>
    </div>
</form>
    <div>
        <!-- <h1>Friends List</h1> -->
        <FriendsList :friends="friends"/>
    </div>
    </template>
    
    <script>
    import FriendService from '../services/FriendService';
    import FriendsList from './FriendsList.vue';
    export default {
        components: {
            FriendsList
        },
        props: {
            guest: {
              type: Object,
            required: true  
            }
        },
        data(){
            return {
                newGuest: {
                    guest_first_name: "",
                    guest_last_name: "",
                    guest_email_address: "",
                    potluck_id: this.$route.params.potluckId
            },
                guestsArray: [],
                friends: []
            };
        },
        methods: {
            addNewGuest(){
                this.guestsArray.push(this.newGuest)
                FriendService.addGuest(this.guestsArray);
                this.resetForm();
            },
            cancelForm(){
                this.$emit('cancel');
                this.resetForm();
            },
            resetForm(){
                this.newGuest = {};
            }
        }
    }
    </script>

<style scoped>
.guest-form {
    font-family: quicksand;
    font-variant: small-caps;
    font-weight: 600;
    text-align: center;
    font-size: larger;
    display: flex;
    margin-right: 20px;
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
    text-align: center;
    font-size: large;
}

</style>
    
    