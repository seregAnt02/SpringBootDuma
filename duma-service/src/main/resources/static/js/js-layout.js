
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



let container = document.getElementsByClassName('container');
let menuContainer = document.getElementsByClassName('menu-container');
const  menu = document.querySelector(".menu > ul > li");

const  sideButton1 = document.getElementsByClassName("side-button-1");
const panel = document.getElementById("id-panel");

function buttonClickPanel(){
    if(panel != null){
        if(panel.classList[0] === "panel-close"){
            panel.classList.remove("panel-close");
            panel.classList.add("panel-open");
        } else {
            panel.classList.remove("panel-open");
            panel.classList.add("panel-close");
        }

    }

}



/*$('.side-button-1 .side-b').click(function () {
    var mas = $('.side-panel').css('left').split('px');
    if (mas.length > 0 && Number.parseInt(mas[0]) > -1)
    {
        $(side_panel).css('left', '-750px');
        $('.side-b').text('close');
    }
    else
    {
        $(side_panel).css('left', '0px');
        $('.side-b').text('open');
    }
});*/
//container[0].classList.add("menu-display")

menuContainer[0].classList.add("menu-header");

menu.classList.add("menu-header");

//console.log(container);