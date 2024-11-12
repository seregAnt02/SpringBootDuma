
let layout = new Vue({
    el: '#layout',
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
        eventMenu: function (){
            buttonClickPanel();
        }
    },
});



let menuContainer = document.getElementsByClassName('menu-container');
const  menu = document.querySelector(".menu > ul > li");

const panel = document.getElementById("id-panel");
const sideB = document.getElementsByClassName("side-b");


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


//container[0].classList.add("menu-display")

menuContainer[0].classList.add("menu-header");

menu.classList.add("menu-header");


const rezults = document.getElementById("rezults");

//------------------------------------

    let layOut = getLayOut();

    //console.log(layOut);

//------------------------------------

async function getLayOut(){

    let hostname = window.location.hostname;
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
}
