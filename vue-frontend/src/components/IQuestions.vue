<template>
  <div>
    <IQuestionOne @toParent="handler" :iquestion="iquestions[this.id]"/>
    <button v-on:click="nextQuestion">Ответить</button>
    <br>
    <br>
    <span>{{ checkedIQuestion }}</span>
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
      id: 0,
      checkedIQuestion: []
    }

  },
  methods: {
    nextQuestion() {
      if (this.id >= 181) {
        this.id = -1
      }

      this.id += 1

      let elem = document.getElementsByTagName('input');
      for (let i = 0; i < elem.length; i++) {
        elem[i].checked = false
      }
    },
    handler(value) {
      this.checkedIQuestion = value
      console.log(this.checkedIQuestion)
    }
  },
  created: function () {
    EventService.getEvents().then(response => {
      this.iquestions = response.data
    })
  }

}
</script>
