<template>
  <div class="potluck-view">
    <div class="banner">
      <img class="logo-left" src="../assets/2-Prawn-logo.png"/>
      <h1>{{ Potluck.eventName }}</h1>
     <img class="logo-right" src="../assets/2-Prawn-logo.png"/>
      <!-- <h2>Hosted By: {{  }}</h2> -->
    </div>
    <div>
      <PotluckDetail v-bind:potluck="Potluck"/>
     </div>
     <div class="guest-head">
      <h2>Guest List</h2>
      <GuestList :guests="guests"/>
     </div>
      <div class="dish-needs">
     <h2>Dish Needs</h2>
      <DishNeedsList :dishNeeds="dishNeeds"/>
      <button class="btn-delete" @click="deleteDishNeeds()" v-if="isHost()">Remove All Dish Needs</button>
      </div>
      <div class="dishes-head">
     <h2>Dishes</h2>
     <DishList dishes="dishes"/>
     <button class="dishList" v-on:click="$router.push({name: 'AddDishView', params: {potluckId: potluckId}})">Add Dish</button>
      
      </div>
    </div>
</template>
<script>
import PotluckDetail from '../components/PotluckDetail.vue';
import PotluckService from '../services/PotluckService';
import GuestList from '../components/GuestList.vue';
import DishNeedsList from '../components/DishNeedsList.vue';
import DishList from '../components/DishList.vue';
import FriendService from '../services/FriendService';

export default {
    components: {
        PotluckDetail,
        GuestList,
        DishNeedsList,
        DishList
    },
    data(){
      return {
        Potluck: {
                eventName: "",
                description: "", 
                eventDate: "",
                eventTime: "",
                diet: "",
                recurring: false,
                frequencyDays: 0,
                location: "",
                private: false
            },
            guests: [],
            guest: {
              guest_first_name: "",
              guest_last_name: "",
              guest_email_address: ""
            },
            allDishNeeds: [],
            dishNeeds: {
                dish_category: "",
                dish_serving_count_needed: 0,
                dish_serving_count_filled: 0
            },
            dishes: [],
            dish: {
              dish_name: "",
                dish_dietary_restrictions: "",
                dish_category: "",
                dish_servings: 0,
                dish_recipe: ""
            }
      };
    },
    created(){
      PotluckService.getPotluck(this.$route.params.potluckId)
      .then(response => {
        this.Potluck = response.data;
      });
      FriendService.guestList(this.$route.params.potluckId)
      .then(response => {
        this.guests = response.data;
      });
      PotluckService.dishNeedsList(this.$route.params.potluckId)
      .then(response => {
        this.allDishNeeds = response.data;
      });
      PotluckService.getAllDishes(this.$route.params.potluckId)
      .then(response => {
        this.dishes = response.data;
      });
    },
    methods: {
      isHost(){
            return this.$store.state.user.id === this.Potluck.userId; 
        },
        deleteDishNeeds(){
      console.log("wasssup");
            if (
        confirm('Are you sure you want to delete all of the dish needs? This cannot be undone.')
      ) {
            PotluckService.deleteDishNeeds(this.$route.params.potluckId).then(()=>{
                this.getAllDishNeeds();
            });
            
        }
      },
    getAllDishNeeds(){
            PotluckService.dishNeedsList(this.$route.params.potluckId)
            .then(response => {
                this.allDishNeeds = response.data;
            });
        }
    }
}
</script>
<style>
.container {
  margin-top: 25%;
  margin-left: 15%;
  font-family: quicksand;
  font-variant: small-caps;
  font-weight: 600;
  font-size: larger;
  display: flex;
  flex-direction: column;
  margin-bottom: 10px;
  border-radius: 15px;
  align-items: center;
  background-color: rgb(252, 191, 188);
  border: 4px solid rgb(255, 127, 80);
  padding-bottom: 5px;
  position: relative;
}
.actions {
  display: grid;
  grid-template-columns: 1fr 1fr;
  grid-template-rows: 1fr 1fr;
  column-gap: 50px;
  row-gap: 20px;
  grid-template-areas: 
  "btn-edit btn-delete"
  "inv-guest update-dish-needs";
}
.btn-edit {
  margin-right: 10px;
  width: 15vw;
  background-color: #bcf9fc;
  border-color: #09C7D1;
  border-radius: 10px;
}
.btn-delete {
  margin-right: 10px;
  width: 15vw;
  border-radius: 10px;
  border-color: #09C7D1;
  background-color: #bcf9fc;
}
.inv-guest {
  margin-right: 10px;
  width: 15vw;
  border-radius: 10px;
  background-color: #bcf9fc;
  border-color: #09C7D1;
}
.update-dish-needs {
  margin-right: 10px;
  width: 15vw;
  border-radius: 10px;
  background-color: #bcf9fc;
  border-color: #09C7D1;
}
.dish-needs {
  margin-bottom: 5%;
  margin-left: 15%;
  font-family: quicksand;
  font-variant: small-caps;
  font-weight: 600;
  font-size: larger;
  display: flex;
  flex-direction: column;
  border-radius: 15px;
  align-items: center;
  background-color: rgb(252, 191, 188);
  border: 4px solid rgb(255, 127, 80);
  /* margin-left: 10px; */
  padding-bottom: 5px;
  position: relative;
}
.guest-head {
  margin-top: 25%;
  margin-right: 15%;
  font-family: quicksand;
  font-variant: small-caps;
  font-weight: 600;
  font-size: larger;
  display: flex;
  flex-direction: column;
  border-radius: 15px;
  align-items: center;
  background-color: rgb(252, 191, 188);
  border: 4px solid rgb(255, 127, 80);
  /* margin-right: 10px; */
  padding-bottom: 5px;
  position: relative;
}
.potluck-view {
  display: grid;
  grid-template-columns: repeat(2, 1fr); 
  grid-template-rows: auto auto;
  column-gap: 30px;
  row-gap: 30px;
}
.dishes-head {
  margin-bottom: 5%;
  font-family: quicksand;
  font-variant: small-caps;
  font-size: larger;
  font-weight: 600;
  align-content: center;
  display: flex;
  flex-direction: column;
  border-radius: 15px;
  align-items: center;
  background-color: rgb(252, 191, 188);
  border: 4px solid rgb(255, 127, 80);
  margin-right: 15%;
  padding-bottom: 5px;
  position: relative;
}
.banner {
  display: flex;
  flex-direction: row;
  font-family: Garamond;
  font-variant: small-caps;
  font-size: xx-large;
  align-items: center;
  justify-content: space-evenly;
  width: 95vw;
  background-color: rgb(252,191,188);
  border: 4px solid rgb(255,127,80);
  padding: 10px 20px;
  border-radius: 15px;
  margin-top: 10px;
  height: 115px;
  position: absolute; 
  top: 40px;
  left: 50%; 
  transform: translateX(-50%);
  background-size: auto;
}
.logo-left,
.logo-right {
  height: 90px;
  position: relative; 
   
}

.logo-left {
  margin-right: auto;
  margin-left: 5%;
  transform: rotateY(180deg)
}

.logo-right {
  margin-left: auto;
  margin-right: 5%;
}
.dishList {
  margin-right: 10px;
  width: 15vw;
  border-radius: 10px;
  background-color: #bcf9fc;
  border-color: #09C7D1;
}
#guest-entry {
  display: flex;
  flex-direction: column;
  width: 22vw;
  border-radius: 5px;
  background-color: #bcf9fc;
  border: 1px solid #09C7D1; 
  margin-right: 3vw;
}

</style>