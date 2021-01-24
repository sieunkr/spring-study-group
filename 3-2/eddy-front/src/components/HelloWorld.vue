<template>
  <v-container>
    <v-row>
      <v-col cols="12">
        <v-text-field
                type="text"
        ></v-text-field>
        <v-btn
                v-on:click="search"
        ><span class="title">search</span></v-btn>
      </v-col>

      <div v-for="movie in movieList" v-bind:key="movie">

        <v-card
                class="mx-auto"
                max-width="400"
        >
          <v-img
                  class="white--text align-end"
                  height="130px"
                  :src="movie.image"
          >
            <v-card-title>{{movie.title}}, 평점={{movie.userRating}}</v-card-title>
          </v-img>

          <v-card-subtitle class="pb-0">
            {{movie.subtitle}}
          </v-card-subtitle>
        </v-card>
      </div>


    </v-row>
  </v-container>
</template>

<script>

  import axios from 'axios'

  export default {
    name: 'HelloWorld',

    data: () => ({
      movieList:[
      ]
    }),
    methods: {
      search: function () {
        axios.get('http://localhost:8081/api/v1/search/movies?q=반지의제왕') .then(res => {
          console.log(res)
          this.movieList = res.data;
        })
      }
    }
  }
</script>
