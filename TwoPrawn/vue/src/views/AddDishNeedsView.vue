<template>
    <div class="need-view">
        <!-- <h1>Add More Dish Needs</h1>
        <p>Use this form to add your dish needs to the potluck! You can indicate to your guests, what kinds of items they should bring, and how many servings.</p> -->
        <DishNeedsForm v-bind:dishNeeds="dishNeeds"/>
        <DishNeedsList />
    </div>

</template>

<script>
import DishNeedsForm from '../components/DishNeedsForm.vue';
import DishNeedsList from '../components/DishNeedsList.vue';
export default {
    components: {
    DishNeedsForm,
    DishNeedsList
},
data () {
    return {
        dishNeeds: {
            potluck_id: this.$route.params.potluckId,
            dish_category: "",
            dish_serving_count: 0,
            dish_serving_count_filled: 0
        }
    }
}
}
</script>

<style scoped>
.need-view {
    margin-top: 10vh;
    display: flex;
    flex-direction: row;
    margin-left: 20%;
    justify-content: flex-start;
    height: 100vh; 
}
.need-list{
    
  display: flex;
    flex-direction: column;
    margin-left: 5%;
    border-radius: 15px;
    border: 4px solid rgb(255,127,80);
    padding: 5px;
    height: 65vh;
    width: 25vw;
    background-color: rgb(252,191,188);
    align-items: center;
}
#need-entry {
  display: flex;
  flex-direction: column;
  width: 22vw;
  border-radius: 5px;
  background-color: #bcf9fc;
  border: 1px solid #09C7D1; 

}
.dishNeedsList{
  display: flex;
  justify-content: center;
}
</style>