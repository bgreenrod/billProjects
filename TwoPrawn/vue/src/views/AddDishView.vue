<template>
<div class="dish-view">


<DishForm v-bind:dish="dish"/>
</div>
</template>


<script>
import DishForm from '../components/DishForm.vue';
export default {
    components: {
        DishForm
    },
    data(){
        return {
            dish: {
                dish_name: "",
                dish_dietary_restrictions: "",
                dish_category: "",
                dish_servings: 0,
                dish_recipe: "",
                username: this.$store.state.user.username
            }
        }
    }
}
</script>

<style scoped>
.dish-view {
    margin-top: 10vh;
    display: flex;
    flex-direction: row;
    margin-left: 20%;
    justify-content: flex-start;
    height: 100vh; 
}
</style>