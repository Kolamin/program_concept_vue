<template>
  <div>
      <ul>
          <li v-for="value in iquestion" :key="value.id">
              {{ value.id }}
          </li>
      </ul>
  </div>
</template>

<script>
    export default {
       props: {
           iquestion: {}
       }
    }
</script>

<style scoped>

</style>