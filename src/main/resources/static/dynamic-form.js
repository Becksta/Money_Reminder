const app = Vue.createApp({})

app.component('button-counter', {
    data(){
        return{
            count: 0
        }
    },
    template:
    `
    <button @click="count++"> 
    You've clicked me {{count}} times.
    </button>
    `
})
app.mount('#app')