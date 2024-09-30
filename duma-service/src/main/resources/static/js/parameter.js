
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

            let form = getParameterForm()

            addToForm()
        },
        addParameterToArreys: function (){

            getAllParameter().then(r => {
                //console.log(this.message);
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


let formLoading = document.getElementById('formLoading');

function addToForm(){

    const parameterId = getParameterId(1)

    const form = formLoading.getElementsByClassName('add-form-class');

    //console.log(formLoading);

    parameterId.then(result => {

        for (let i = 0; i < form[0].length; i++){
            let id = form[0][i].getAttribute('id');
            if(id == 'id') form[0][i].setAttribute('value', result.id)
            if(id == 'datetime') form[0][i].setAttribute('value', result.datetime)
            if(id == 'parameter') form[0][i].setAttribute('value', result.parameter)
            if(id == 'codParameter') form[0][i].setAttribute('value', result.codParameter)
            if(id == 'lastUpdate') form[0][i].setAttribute('value', result.lastUpdate)
            if(id == 'meaning') form[0][i].setAttribute('value', result.meaning)

        }
        //console.log(formLoading);
    });
}

async function getParameterId(id){

    let hostname = window.location.hostname;

    let url = hostname == "localhost" ? "/parameter/" + id : "/#/parameter/" + id;

    let response = await fetch( url, {

        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type':'application/json;charset=utf-8'
            //"Content-Type": "application/x-www-form-urlencoded"
        }

    });
    if (response.ok === true) {

        const result = await response.json();

        return result;

    }
}

async function getParameterForm(){

    let hostname = window.location.hostname;
    let url = hostname == "localhost" ? "/home/updateParameter" : "/#/home/updateParameter";

    let response = await fetch( url, {

        method: 'GET',
        headers: {
            //'Content-Type': 'application/json;charset=utf-8'
            'Content-Type': 'text/html;charset=utf-8'
            //'Content-Type':'multipart/form-data'
            //"Content-Type": "application/x-www-form-urlencoded; charset=UTF-8"
        }

    });

    if (response.ok === true) {

        //return response.text();
        formLoading.setAttribute("zIndex", "1");

        formLoading.innerHTML = await response.text();
    }

    return formLoading;
}


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




