<template>
  <div id="login">
    <div class="banner">
      <img class="logo-left" src="../assets/2-Prawn-logo.png"/>
    <h1 class="title">Two Prawn Potluck Planner</h1>
    <!-- <h2 class="welcome-message">Welcome Back!</h2> -->
     <img class="logo-right" src="../assets/2-Prawn-logo.png"/>
  </div>
    <form class="login-box" v-on:submit.prevent="login">
      
      <h1 class="please">Please sign In</h1>
      <div role="alert" v-if="invalidCredentials">
        Invalid username and password!
      </div>
      <div role="alert" v-if="this.$route.query.registration">
        Thank you for registering, please sign in.
      </div>
      <div class="form-input-group" id="username">
        <label for="username">Username</label>
        <input type="text" id="username" v-model="user.username" placeholder="Username" required autofocus />
      </div>
      <div class="form-input-group" id="password">
        <label for="password">Password</label>
        <input type="password" id="password" v-model="user.password" placeholder="Password" required />
      </div>
      <button class="signin" type="submit">Sign in</button>
      <p>
      <router-link class="reg-button" v-bind:to="{ name: 'register' }">Need an account? Sign up.</router-link></p>
    </form>
  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: ""
      },
      invalidCredentials: false
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
};
</script>

<style scoped>
.form-input-group {
  margin-top: 1rem;
  margin-bottom: 2rem;
  display: flex;
  flex-direction: column;
  align-items: center;
}

label {
  margin-right: 0.5rem;
}

#login {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  height: 100vh; 
  text-align: center;
}

.login-box {
  font-family: quicksand;
  font-variant: small-caps;
  font-weight: 600;
  font-size: larger;
  display: flex;
  flex-direction: column; 
  border-radius: 15px;
  align-items: center; 
  justify-content: flex-start; 
  margin-top: 100px;
  width: 300px;
  background-color: rgb(252, 191, 188);
  border: 4px solid rgb(255, 127, 80);
  height: 60%;
}
.signin{
  margin-right: 10px;
  width: 10vw;
  border-radius: 10px;
  background-color: #bcf9fc;
  border-color: #09C7D1;
}
.banner {
  /* display: flex;
  flex-direction: row; */
  font-family: garamond;
  font-size: x-large;
  font-variant: small-caps;
  /* align-items: center; */
  /* justify-content: space-evenly; */
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
  transform: rotateY(180deg);
  position: relative; 
}
.logo-right {
  position: relative;
}
.please {
  margin-bottom: 20px;
  font-family: garamond;
}
</style>