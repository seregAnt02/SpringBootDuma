
let app = new Vue({
    el: '#app',
    data: {
        message: 'Тише, мыши, кот на крыше',
        rows: [
            /*{ id: '1', datetime: '01/01/01', parameter:'MQ-2', codParameter:'asd', lastUpdate:'***', meaning:'1'},
            { id: '2', datetime: '02/01/01', parameter:'MQ-3', codParameter:'abc', lastUpdate:'*', meaning:'2'}*/
        ],
        login: 'abc'
    },
    methods: {
        changeText: function() {
            this.message = 'А котята ещё выше';
        },
        showAlert: function(text) {
            alert(text)
        },
        eventUpdate: function (id, event, index) {
            // .value is needed in JavaScript
            alert(id);
        },
        addParameterToArreys: function (){

            getAllParameter().then(r => {
                console.log(this.message);
            });
        }
    },
});

app.addParameterToArreys();

async function addArreysParameter(result){

    for (let i = 0; i < result.length; i++){
        app.rows.push(result[i]);
    }

    //app.rows.push({ id: '3', datetime: '03/03/03', parameter:'MQ-3', codParameter:'asd', lastUpdate:'***', meaning:'3'})
}


//let formLoading = document.getElementById('formLoading');


async function getAllParameter() {

    let hostname = window.location.hostname;

    let url = hostname == "localhost" ? "/parameter" : "/spring-boot-duma/parameter";

    let response = await fetch(url, {

        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json;charset=utf-8'
            //"Content-Type": "application/x-www-form-urlencoded"
        }

    });

    //console.dir(id);

    if (response.ok === true) {

        const result = await response.json();

        await addArreysParameter(result);
        //console.log(result);
    }
}


