<template>
    <div class="create">
        <h1 id="create-head">Create A New Potluck</h1>
        <PotluckForm v-bind:potluck="potluck" />
    </div>
</template>

<script>
import PotluckForm from '../components/PotluckForm.vue';

export default {
    components: {
        PotluckForm
    },
    data() {
        return {
            potluck: {
                id: "",
                name: "",
                description: "", 
                date: "",
                time: "",
                creator: "",
                dietaryRestrictions: "",
                isRecurring: "",
                frequency: "",
                location: "",
                isPrivate: ""
      },
    }
  }
};
</script>

<style>
#create-head {
    font-family: garamond;
    font-size: xxx-large;
    text-align: center;
    text-decoration: underline;
    margin-bottom: 5px;
}


</style>