<template>
<form v-on:submit.prevent="addNewDishNeed">
    <div class="need-form">
        <h1 id="need-head">Add More Dish Needs</h1>
        <label for="dish_category">Needed Dish Category:</label>
        <input id="dish_category_input" list="dish_category" name="dish_category" v-model="newDishNeeds.dish_category">
            <datalist id="dish_category">
                <option value="Dessert"></option>
                <option value="Appetizer"></option>
                <option value="Entree"></option>
                <option value="Sides"></option>
                <option value="Salad"></option>
                <option value="Soup"></option>
                <option value="BBQ"></option>
                <option value="Casseroles"></option>
                <option value="Hamburgers"></option>
                <option value="Hotdogs"></option>
                <option value="Chicken"></option>
                <option value="Fish"></option>
                <option value="Pasta"></option>
                <option value="Pizza"></option>
                <option value="Beef"></option>
                <option value="Breakfast"></option>
                <option value="Pork"></option>
                <option value="Pizza"></option>
                <option value="Rice"></option>
                <option value="Beans"></option>
                <option value="Seafood"></option>
                <option value="Vegetables"></option>
                <option value="Mac and Cheese"></option>
                <option value="Shrimp"></option>
                <option value="Prawns"></option>
                <option value="Bread"></option>
                <option value="Curry"></option>
                <option value="Sandwiches"></option>
                <option value="Chips"></option>
                <option value="Beer"></option>
                <option value="Wine"></option>
                <option value="Seltzers"></option>
                <option value="Non-Alcoholic Drinks"></option>
                <option value="Other"></option>
            </datalist>
        <label for="servings">How many servings is this dish?</label>
        <input id="servings" type="number" v-model="newDishNeeds.dish_serving_count_needed">
    <div class="buttons">
    <input class="submitbtn" type="submit" value="Save" />
    <input class="cancelbtn" type="button" value="Clear" @click="cancelForm"/>
    </div>
<p id="done">Done adding dish needs? <router-link :to="{name: 'PotluckView', params: {potluckId: $route.params.potluckId}}">Click Me!</router-link></p>
</div>
</form>
</template>

<script>
import PotluckService from '../services/PotluckService';
export default {
    props: {
        dishNeeds: {
            type: Object,
            required: true
        }
    },
    data(){
        return {
            newDishNeeds: {
                potluck_id: this.$route.params.potluckId,
                dish_category: "",
                dish_serving_count_needed: 0,
                dish_serving_count_filled: 0
            },

        };
    },
    methods: {
        addNewDishNeed(){
            if(this.newDishNeeds.dish_serving_count_needed > 0){
                console.log("hiiiiiiiii");
              PotluckService.addDishNeeds(this.$route.params.potluckId, this.newDishNeeds);
              console.log("hello");
            this.resetForm();  
            }
        },
        cancelForm(){
            this.$emit('cancel');
            this.resetForm();
        },
        resetForm(){
            this.newDishNeeds = {};
        }
    }
}
</script>
<style>
.need-form {
    font-family: quicksand;
  font-variant: small-caps;
  font-weight: 600;
  font-size: larger;
    display: flex;
    flex-direction: column;
    margin-top: 1%;
    /* margin-left: 18%; */
    border-radius: 15px;
    border: 4px solid rgb(255,127,80);
    padding: 5px;
    width: 13vw;
    background-color: rgb(252,191,188)
}

.buttons {
    margin-top: 10px;
    display: flex;
    flex-direction: row;
    justify-content: space-evenly;
}
#done {
    
    text-align: center;
    font-size: large;
}
#need-head {
    font-size: large;
}
.submitbtn {
   margin-right: 10px;
  width: 10vw;
  border-radius: 10px;
  background-color: #bcf9fc;
  border-color: #09C7D1;
}
.cancelbtn {
  margin-right: 10px;
  width: 10vw;
  border-radius: 10px;
  background-color: #bcf9fc;
  border-color: #09C7D1;
}
</style>