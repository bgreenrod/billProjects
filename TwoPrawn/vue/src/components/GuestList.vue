<template>
  <div class="whole-guest">
    <div class="guestsListBox" v-for="guest in guests" :key="guest.guest_email_address">
      <div>
        <p id="guest-list" v-if="showCheckboxForGuest(guest)">
          <input 
            type="checkbox" 
            v-on:click="putGuestsInArray(guest)"/> 
          {{ guest.guest_first_name }} {{ guest.guest_last_name }} | {{ guest.guest_email_address }} 
        </p>
        
        <p  v-else>
          {{ guest.guest_first_name }} {{ guest.guest_last_name }} | {{ guest.guest_email_address }} 
        </p>
        <button class="btn-delete" v-on:click="(deleteGuestThenGoHome())" v-if="isCurrentUserGuest(guest)">Leave Potluck</button>
      </div>
    </div>
    <button class="btn-delete" v-on:click="(deleteGuest())" v-if="showRemoveGuestsButton">Remove Selected Guests</button>
  </div>
</template>

<script>
import FriendService from '../services/FriendService';
export default {

  data() {
    return {
      guests: [],
      guestsToRemove: [],
      selfRemoval: [],
    };
  },
  computed: {
    currentUserInGuestList() {
      return this.guests.some(guest => guest.guest_email_address === this.$store.state.user.email);
    },
    showRemoveGuestsButton() {
      return !this.guests.some(guest => this.isCurrentUserGuest(guest));
    }
  },
  methods: {
    getGuests() {
      FriendService.guestList(this.$route.params.potluckId)
      .then(response => {
        this.guests = response.data;
      })
    },
    deleteGuest(){
      if (
        confirm('Are you sure you want to delete these guests? This cannot be undone.')
      ) {
        FriendService.deleteGuest(this.guestsToRemove).then(()=>{
          this.getGuests();
        });
      }
    },
    deleteGuestThenGoHome(){
      if (
        confirm('Are you sure you want to leave this potluck? This cannot be undone, and you will need another invite to be able to see the details.')
      ) {
        FriendService.deleteGuest(this.guestsToRemove).then(()=>{
          this.getGuests();
          this.$router.push({path: '/'});
        });
      }
    },
    isCurrentUserGuest(guest){
      return this.$store.state.user.email === guest.guest_email_address;
    },
    showCheckboxForGuest(guest) {
      return !this.currentUserInGuestList || this.isCurrentUserGuest(guest);
    },
    putGuestsInArray(guest){
      const guestCopy = Object.assign({}, guest);
      const removableGuest = {
        guest_email_address: guestCopy.guest_email_address,
        potluck_id: guestCopy.potluck_id,
        guest_id: guestCopy.guest_id
      };
      const index = this.guestsToRemove.findIndex(item =>
    item.guest_email_address === removableGuest.guest_email_address &&
    item.potluck_id === removableGuest.potluck_id &&
    item.guest_id === removableGuest.guest_id
    );
    if (index !== -1) {
    this.guestsToRemove.splice(index, 1);
  } else {
    this.guestsToRemove.push(removableGuest);
  }
    },
  },
  created(){
    this.getGuests(this.$route.params.potluckId);
  }
}
</script>

<style scoped>
#guest-list {
  font-family: quicksand;
  font-variant: small-caps;
  font-weight: 600;
  font-size: larger;
  display: flex;
  flex-direction: row;
  justify-content: flex-start;
  width: 25vw;
  border-radius: 5px;
  background-color: #bcf9fc;
  border: 1px solid #09C7D1; 
}


</style>