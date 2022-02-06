<template>
  <div>
    <h3>{{ iquestion.id }}. {{ iquestion.name }}</h3>
    <div v-for="(value, index) in iquestion.testOptions" :key="index">
      <input type="checkbox" id="checkQuest" :value="value">
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
  }
}
</script>

<style scoped>

</style>