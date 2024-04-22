<template>
<div class="friend-list">
  <h2 id="friend-list-head">Friends List</h2>
    <div class="friendsListBox" v-for="friend in friends" v-bind:key="friend.user_id">
      <ul>
        <li id="friend-entry">{{ friend.friend_first_name }} {{ friend.friend_last_name }} -- {{ friend.friend_email_address }}</li>
      </ul>
    </div>
</div>
</template>

<script>
import FriendService from '../services/FriendService';
export default {

    data() {
    return {
      friends: [],
    };
  },
  methods: {
    getFriends() {
      FriendService.friendsList()
      .then(response => {
        this.friends = response.data;
      })
    }
  },
  created(){
    this.getFriends();
  }
}
</script>

<style>
.friend-list{
  font-family: quicksand;
  font-variant: small-caps;
  font-weight: 600;
  font-size: larger;
  display: flex;
    flex-direction: column;
    margin-left: 2%;
    border-radius: 15px;
    border: 4px solid rgb(255,127,80);
    padding: 5px;
    height: 100%;
    width: 25vw;
    background-color: rgb(252,191,188);
    align-items: center;
}
#friend-entry {
  display: flex;
  flex-direction: column;
  width: 22vw;
  border-radius: 5px;
  background-color: #bcf9fc;
  border: 1px solid #09C7D1; 
  margin-right: 3vw;
}
.friendsListBox{
  
  display: flex;
  justify-content: center;
}
.friend-list-head{
  font-family: garamond;
  
}


</style>
