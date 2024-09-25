
const { createApp, ref } = Vue

createApp({
    setup() {
        let message = ref('Hello vue!')

        function increment() {
            // .value is needed in JavaScript
            //message = 'abc'
            showAlert()
        }

        return {
            message,
            increment
        }
    }
}).mount('#app')


/*
let app = new Vue({
    el: '#contents',
    methods: {
        eventUpdate() {
            showAlert();
        }
    }
});*/

//const body = document.getElementById("element");

function showAlert() {
    alert("The button was clicked!");
}
