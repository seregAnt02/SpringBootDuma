
const { createApp, ref } = Vue

createApp({
    setup() {
        let message = ref('Hello vue!')

        return {
            message
        }
    },
    data() {
        return{
            rows: [
                { id: '1', datetime: '01/01/01', parameter:'MQ-2', codParameter:'asd', lastUpdate:'***', meaning:'1'},
                { id: '2', datetime: '02/01/01', parameter:'MQ-3', codParameter:'abc', lastUpdate:'*', meaning:'2'}
            ]
        }
    },
    methods: {
        showAlert: function(text) {
            alert(text)
        },
        eventUpdate: function (id, event, index) {
            // .value is needed in JavaScript
            alert(id);
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

/*function showAlert(text) {
    alert("The button was clicked! " + text);
}*/
