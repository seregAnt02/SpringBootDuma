
/*window.onload = async function(){

    /!*const vueSphereActivity = await import('/js/jsSphereActivity.js');
    console.log(vueSphereActivity.vueSphereActivity.user);*!/
}*/

let layout = new Vue({
    el: '#layout',
    data: {
        message: 'Тише, мыши, кот на крыше',
        rows: [
            /*{ id: '1', datetime: '01/01/01', parameter:'MQ-2', codParameter:'asd', lastUpdate:'***', meaning:'1'},
            { id: '2', datetime: '02/01/01', parameter:'MQ-3', codParameter:'abc', lastUpdate:'*', meaning:'2'}*/
        ],
        login: 'abc',
        user: ''/*,
        contentHtml: '<input type="radio" value="111" v-model="user">' +
            ' <label>Автоматизаций объектов.</label>' + "<br/>" +
            '<input type="radio" value="222" v-model="user">' +
            ' <label>Автом.</label>'*/
    },
    methods: {
        getMenuServices: function () {

        },
        getMenuLayOut: function() {
            //this.message = 'А котята ещё выше';
            let layOut = getLayOut();
            //console.log(layOut);
        },
        eventMenu: function (){
            buttonClickPanel();
        },
        clickRefMenuCompany: function(){
            clickRefCompany();
        },
        clickRefMenuServices: function(){
            clickRefServices();
        },
        clickRefMenuPrices: function(){
            clickRefPrices();
        },
        clickRefMenuCoordinates: function(){
            clickRefCoordinates();
        }
    },
});

//------------------------------//
let menuContainer = document.getElementsByClassName('menu-container');
const  menu = document.querySelector(".menu > ul > li");

const panel = document.getElementById("id-panel");
const sideB = document.getElementsByClassName("side-b");

let hostname = window.location.hostname;

const rezults = document.getElementById("rezults");

//------------------------------//
// menu
//------------------------------//
async function clickRefCompany(){

    let url = hostname == "localhost" ? "/home/company-page" : "/#/home/company-page";

    let response = await fetch( url, {

        method: 'GET',
        headers: {
            'Content-Type': 'text/html;charset=utf-8'
        }

    });

    if (response.ok === true) {

        let result = await response.text();

        rezults.innerHTML = result;

        return result;
    }
    //console.log("company");
}

async function clickRefServices(){

    let url = hostname == "localhost" ? "/home/services-page" : "/#/home/services-page";

    let response = await fetch( url, {

        method: 'GET',
        headers: {
            'Content-Type': 'text/html;charset=utf-8'
        }

    });

    if (response.ok === true) {

        let result = await response.text();

        rezults.innerHTML = result;

        return result;
    }
    //console.log("services");
}

async function clickRefPrices(){

    let url = hostname == "localhost" ? "/home/sphere-activity" : "/#/home/sphere-activity";

    let response = await fetch( url, {

        method: 'GET',
        headers: {
            'Content-Type': 'text/html;charset=utf-8'
        }

    });

    if (response.ok === true) {

        let result = await response.text();

        rezults.innerHTML = result;

        return result;
    }
}

async function clickRefCoordinates(){

    let url = hostname == "localhost" ? "/home/coordinate-page" : "/#/home/coordinate-page";

    let response = await fetch( url, {

        method: 'GET',
        headers: {
            'Content-Type': 'text/html;charset=utf-8'
        }

    });

    if (response.ok === true) {

        let result = await response.text();

        rezults.innerHTML = result;

        return result;
    }
}
//------------------------------//
function buttonClickPanel(){
    if(panel != null){
        if(panel.classList[1] === "panel-close"){
            panel.classList.remove("panel-close");
            panel.classList.add("panel-open");
            sideB[0].textContent = "close";
        } else {
            panel.classList.remove("panel-open");
            panel.classList.add("panel-close");
            sideB[0].textContent = "open";
        }

    }

}
//------------------------------//
//layout.getMenuLayOut();

menuContainer[0].classList.add("menu-header");
menu.classList.add("menu-header");

//------------------------------//
//------------------------------//


async function getLayOut(){

    let url = hostname == "localhost" ? "/home/start-page" : "/#/home/start-page";

    let response = await fetch( url, {

        method: 'GET',
        headers: {
            'Content-Type': 'text/html;charset=utf-8'
        }

    });

    if (response.ok === true) {

        let result = await response.text();

        rezults.innerHTML = result;

        return result;
    }
    //------------------------------//
}

