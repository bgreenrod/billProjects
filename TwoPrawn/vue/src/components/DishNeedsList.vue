<template>
<div class="need-list">
    <!-- <h2 id="need-head">Dish Needs List</h2> -->
<div class="dishNeedsBox" v-for="dishNeeds in dishNeedsList" v-bind:key="dishNeeds.dish_category_id">
    <div>
        <p id="need-entry">{{ dishNeeds.dish_category }} | {{ dishNeeds.dish_serving_count_filled }} of {{ dishNeeds.dish_serving_count_needed }} servings filled</p>
    </div>
</div>
</div>
</template>


<script>
import PotluckService from '../services/PotluckService';
export default {
    data () {
        return {
            dishNeedsList: [],
        };
    },
    methods: {
        getAllDishNeeds(){
            PotluckService.dishNeedsList(this.$route.params.potluckId)
            .then(response => {
                this.dishNeedsList = response.data;
            });
        },
        deleteDishNeeds(){
            if (
        confirm('Are you sure you want to delete all of the dish needs? This cannot be undone.')
      ) {
            PotluckService.deleteDishNeeds(this.$route.params.potluckId)
            .then(()=>{
                this.getAllDishNeeds();
            });
            
        }
    },
    
},
    created(){
        this.getAllDishNeeds(this.$route.params.potluckId);
    }
}
</script>


<style scoped>
#need-entry {
    font-family: quicksand;
  font-variant: small-caps;
  font-weight: 600;
  font-size: larger;
  display: flex;
  flex-direction: column;
  width: 22vw;
  border-radius: 5px;
  background-color: #bcf9fc;
  border: 1px solid #09C7D1; 

}
</style>