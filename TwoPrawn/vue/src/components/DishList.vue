<template>
<div class="dishListBox" v-for="dish in dishes" v-bind:key="dish.dish_id">
    <div class="dish-list">
        <h3>{{dish.username}} is bringing {{ dish.dish_name }}</h3>
        <p v-if="dish.dish_dietary_restrictions">Dietary Restrictions: {{ dish.dish_dietary_restrictions }}</p>
        <p>Category: {{ dish.dish_category }} | {{ dish.dish_servings }} servings</p>
        <p v-if="dish.dish_recipe">Recipe: {{ dish.dish_recipe }}</p>
    </div>
</div>
</template>


<script>
import PotluckService from '../services/PotluckService';
export default {
    data(){
        return {
            dishes: [],
        };
    },
    methods: {
        getAllDishes(){
            PotluckService.getAllDishes(this.$route.params.potluckId)
            .then(response => {
                this.dishes = response.data;
            })
        }
    },
    created(){
        this.getAllDishes(this.$route.params.potluckId);
    }
}
</script>


<style>
.dish-list {
  font-family: quicksand;
  font-variant: small-caps;
  text-align: center;
  font-weight: 600;
  font-size: larger;
  display: flex;
  flex-direction: column;
  justify-content: flex-start;
  width: 30vw;
  border-radius: 5px;
  margin-bottom: 15px;
  background-color: #bcf9fc;
  border: 1px solid #09C7D1; 
}
h3 {
    margin-top: 0px;
    margin-bottom: 0px;
}
p {
    margin-bottom: 1px;
}
</style>