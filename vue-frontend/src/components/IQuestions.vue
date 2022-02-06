<template>
  <div>
    <IQuestionOne :iquestion="iquestions[this.id]"/>
    <button v-on:click="nextQuestion">Ответить</button>
  </div>
</template>

<script>
import EventService from '../services/EventService.js'
import IQuestionOne from '../components/IQuestionOne.vue'

export default {
  components: {
    IQuestionOne
  },
  name: "IQuestions",
  data() {
    return {
      iquestions: [],
      id: 0
    }

  },
  methods: {
    nextQuestion() {
      if(this.id >= 181){
        this.id = -1
      }
      this.id += 1;
    }
  },
  created: function () {
    EventService.getEvents().then(response => {
      this.iquestions = response.data
    })
  }

}
</script>
