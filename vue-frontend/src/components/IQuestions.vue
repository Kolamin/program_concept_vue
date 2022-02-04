<template>
    <div>
        <IQuestionOne v-for="iquestion in iquestions" :key="iquestion.id"  :iquestion="iquestion"/>

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
                iquestions: []
            }

        },
        created: function() {
          EventService.getEvents().then(response =>{
              this.iquestions = response.data
            })
        }

    }
</script>
