<template>
    <div>
        <h3>{{ iquestion.id }}. {{iquestion.name}}</h3>
        <ul v-for="value in iquestion.testOptions" :key="value.id">
            <li>{{value}}</li>
        </ul>
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