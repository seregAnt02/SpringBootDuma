
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
        addRowTable: function(){

            iconEventClickAdd();

            addParameterToTable()
        },
        changeText: function() {
            this.message = 'А котята ещё выше';
        },
        deleteRowParameterAtTable: function(id, event) {

            iconEventClickDelete(event);

            deleteParameterToTable(id).then(result => {

                window.location.href = "/home/index";
            });
        },
        eventUpdate: function (id, event, index) {

            iconEventClickUpdata(event);

            getParameterForm().then(r => {
                addToForm(id).then(r => {});
            })
        },
        addParameterToArreys: function (){

            getAllParameter().then(r => {
                //console.log(this.message);
            });
        }
    },
});

//----------------------------------

app.addParameterToArreys();

//----------------------------------
let formLoading = document.getElementById('formLoading');
//----------------------------------

async function deleteParameterToTable(id){

    let hostname = window.location.hostname;

    let url = hostname == "localhost" ? "/parameter/" + id : "/#/parameter/" + id;

    let response = await fetch( url, {

        method: 'DELETE',
        headers: {
            'Accept': 'application/json',
            'Content-Type':'application/json;charset=utf-8'
            //"Content-Type": "application/x-www-form-urlencoded"
        }
    });
    if (response.ok === true) {

        const result = await response.text();

        return result;
    }
}

function addParameterToTable() {

    getParameterForm().then(result => {

        const form = document.getElementById('id-form-parameter');

        const btnCancel = document.getElementById('btn_cancel');

        const btnOk = document.getElementById('btn_ok');

        const loginHeader = form.getElementsByClassName('login-header');

        loginHeader[0].textContent = "Добавить строку?"

        btnCancel.onclick = async function (event) {

            form.classList.remove('add-form-css')
            form.classList.add('form-cleaning');
        }

        btnOk.onclick = async function (event) {

            await createParameter();
        }
    });
}

async function createParameter(){

    let hostname = window.location.hostname;

    let url = hostname == "localhost" ? "/parameter/create" : "/#/parameter/create";

    let response = await fetch( url, {

        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type':'application/json;charset=utf-8'
            //"Content-Type": "application/x-www-form-urlencoded"
        }
    });
    if (response.ok === true) {

        const result = await response.text();

        window.location.href = "/home/index";
    }
}

async function editParameter(json){
    let hostname = window.location.hostname;

    let url = hostname == "localhost" ? "/parameter/edit" : "/#/parameter/edit";

    let response = await fetch( url, {

        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type':'application/json;charset=utf-8'
            //"Content-Type": "application/x-www-form-urlencoded"
        },
        body: json

    });
    if (response.ok === true) {

        const result = await response.text();

        window.location.href = "/home/index";
    }
}

async function addToForm(id){

    const parameterId = getParameterId(id)

    await parameterId.then(result => {

        const form = document.getElementById('id-form-parameter');

        const loginHeader = form.getElementsByClassName('login-header');

        loginHeader[0].textContent = loginHeader[0].textContent + ' ' + result.id

        for (let i = 0; i < form.length; i++){
            let nameId = form[i].getAttribute('id');
            if(nameId == 'id') form[i].setAttribute('value', result.id)
            if(nameId == 'datetime') form[i].setAttribute('value', result.datetime)
            if(nameId == 'parameter') form[i].setAttribute('value', result.parameter)
            if(nameId == 'codParameter') form[i].setAttribute('value', result.codParameter)
            if(nameId == 'lastUpdate') form[i].setAttribute('value', result.lastUpdate)
            if(nameId == 'meaning') form[i].setAttribute('value', result.meaning)

        }

        //console.log(loginHeader);

        const btnCancel = document.getElementById('btn_cancel');

        const btnOk = document.getElementById('btn_ok');

        btnCancel.onclick = async function(event){

            form.classList.remove('add-form-css')
            form.classList.add('form-cleaning');
        }

        btnOk.onclick = async function(event){

            let js = {
                id: '',
                datetime: '',
                parameter: '',
                codParameter: '',
                lastUpdate: '',
                meaning: ''
            };

            for (let x = 0; x < form.length; x++){
                let nameId = form[x].getAttribute('id');
                if(nameId == 'id') js.id = form[x].value;
                if(nameId == 'datetime') js.datetime = form[x].value;
                if(nameId == 'parameter') js.parameter = form[x].value;
                if(nameId == 'codParameter') js.codParameter = form[x].value;
                if(nameId == 'lastUpdate') js.lastUpdate = form[x].value;
                if(nameId == 'meaning') js.meaning = form[x].value;

            }

            let jsParameter = JSON.stringify(js);

            await editParameter(jsParameter);
        }

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
    let url = hostname == "localhost" ? "/home/formParameter" : "/#/home/formParameter";

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

        formLoading.setAttribute("zIndex", "1");

        let result = await response.text();

        formLoading.innerHTML = result;

        return result;
    }
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

    if (response.ok === true) {

        const result = await response.json();

        await addArreysParameter(result);
    }
}

async function addArreysParameter(result){

    for (let i = 0; i < result.length; i++){
        app.rows.push(result[i]);
    }

    //app.rows.push({ id: '3', datetime: '03/03/03', parameter:'MQ-3', codParameter:'asd', lastUpdate:'***', meaning:'3'})
}

function iconEventClickDelete(event){

    let hostname = window.location.hostname;
    let urlDark = hostname == "localhost" ? "/images/png-icons-delete-dark.png" : "/#/images/png-icons-delete-dark.png";
    let url = hostname == "localhost" ? "/images/png-icons-delete.png" : "/#/png-icons-delete.png";

    event.target.setAttribute("src", urlDark);
    setTimeout(() => {

        event.target.setAttribute("src", url);

    }, 75);
}

function iconEventClickUpdata(event){

    let hostname = window.location.hostname;
    let url_icons_dark = hostname == "localhost" ? "/images/png-icons-put-dark.png" : "/#/images/png-icons-put-dark.png";
    let url_icons = hostname == "localhost" ? "/images/png-icons-put.png" : "/#/images/png-icons-put.png";

    event.target.setAttribute("src", url_icons_dark);
    setTimeout(() => {

        event.target.setAttribute("src", url_icons);

    }, 75);

}

function iconEventClickAdd(){

    let imgAddRow = document.getElementsByClassName('img_add_row')[0];

    let hostname = window.location.hostname;

    let url_plus_dark = hostname === "localhost" ? "/images/png-icons-plus-dark.png" : "/#/images/png-icons-plus-dark.png";

    imgAddRow.setAttribute("src", url_plus_dark);

    setTimeout(() => {

        let url_plus = hostname === "localhost" ? "/images/png-icons-plus.png" : "/#/images/png-icons-plus.png";
        imgAddRow.setAttribute("src", url_plus);

    }, 75);
}




