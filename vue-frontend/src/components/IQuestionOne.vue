<template>
  <div>
    <h3>{{ iquestion.id }}. {{ iquestion.name }}</h3>
    <div v-for="(value, index) in iquestion.testOptions" :key="index">
      <input type="checkbox" id="checkQuest" :value="value" :checked="check" v-model="selectedAnswer" v-on:change="passAtr">
      <label for="checkQuest">{{ value }}</label>
      <br>
      <br>
    </div>
  </div>
</template>

<script>
export default {
  props: {
    iquestion: {},
  },
  data(){
    return{
      check: false,
      selectedAnswer: []
    }
  },
  methods:{
    passAtr(){
      this.$emit('toParent', this.selectedAnswer)
    }
  }
}
</script>

<style scoped>

</style>