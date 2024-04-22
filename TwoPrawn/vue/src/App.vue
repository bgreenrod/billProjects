<template>
  <div id="capstone-app">
    <div id="nav">
      <!-- need pipe -->
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{name: 'friends'}">Friends</router-link>&nbsp;|&nbsp;
      <div class="myName"> Hello {{this.$store.state.user.username}}, welcome</div>
    </div>
    <router-view />
  </div>
</template>

<style >
#capstone-app {
  background-image: url("./assets/2-prawn-pattern.png"); 
  background-size: cover;  
  background-attachment: fixed; /* Background fixed so it won't scroll with content */
  background-position: center; 
  background-repeat: no-repeat; 
  font-family: cursive;
  min-height: 100vh; /* Set minimum height to fill the viewport */
  position: relative; /* Add position relative to enable z-index for other content */
}

#nav {
  display: flex;
  flex-direction: row;
  background-color: rgba(255, 255, 255, 0.7); 
  padding: 10px;
  position:sticky;
  top: 0;
  z-index: 1;
}
@font-face {
  font-family: 'garamond';
  src: url('./assets/fonts/EB_Garamond/garamond.ttf');
}
@font-face {
  font-family: 'quicksand';
  src: url('./assets/fonts/Quicksand/quicksand.ttf');
}

.myName{
  color:  rgb(55, 160, 160);
}

</style>