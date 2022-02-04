<template>
    <div>
        <IQuestionOne :iquestion="question"/>
    </div>
</template>

<script>
    import EventService from '../services/EventService.js'
    import IQuestionOne from '../components/IQuestionOne.vue'
    export default {
        props:['id'],
        components: {
            IQuestionOne
        },
        name: "IShowOne",
        data(){
            return{
                question:{},
            }
        },
        created() {
            EventService.getEvent(this.id).then(response =>
                this.question = response.data
            )
        }
    }
</script>

<style scoped>

</style>