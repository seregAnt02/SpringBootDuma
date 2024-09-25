
const { createApp, ref } = Vue

createApp({
    setup() {
        let message = ref('Hello vue!')

        function increment(text) {
            // .value is needed in JavaScript
            //message = 'abc'
            showAlert(text)
        }

        return {
            message,
            increment
        }
    }
}).mount('#app')

/*let app = new Vue({
    el: '#app',
    data: {
        message: 'Тише, мыши, кот на крыше'
    },
    methods: {
        changeText: function() {
            this.message = 'А котята ещё выше';
        }
    },
});*/

/*let app = new Vue({
    el: '#contents',
    methods: {
        showAlert: function(text) {
            alert(text)
        }
    }
});*/

//const body = document.getElementById("element");

function showAlert(text) {
    alert("The button was clicked! " + text);
}
