
let company = new Vue({
    el: '#company',
    data: {
        message: 'Тише, мыши, кот на крыше',
        rows: [
        ],
        login: 'abc',
        panel: '',
        sideB: ''
    },
    methods: {
        loadPanel: function (){
            let panelMenu = getPanelMenu();
            panelMenu.then( r => {
                    this.panel = document.getElementById("id-panel");
                    this.sideB = document.getElementsByClassName("side-b");
                }
            );
        },
        eventPanel: function (){
            buttonClickPanel();
        }
    },
});

//----------------------------//
let hostname = window.location.hostname;
const formLoad = document.getElementById("form-load");
//----------------------------//
//----------------------------//

company.loadPanel();

//----------------------------//

function buttonClickPanel(){
    if(company.panel != null && company.sideB != null){
        if(company.sideB[0].textContent === "close"){
            company.panel.classList.remove("panel-close");
            company.panel.classList.add("panel-open");
            company.sideB[0].textContent = "open";
        } else {
            company.panel.classList.remove("panel-open");
            company.panel.classList.add("panel-close");
            company.sideB[0].textContent = "close";
        }

    }

}


async function getPanelMenu(){

    let url = hostname == "localhost" ? "/home/panel-menu" : "/#/home/panel-menu";

    let response = await fetch( url, {

        method: 'GET',
        headers: {
            'Content-Type': 'text/html;charset=utf-8'
        }

    });

    if (response.ok === true) {

        let result = await response.text();

        formLoad.innerHTML = result;

        return result;
    }
    //------------------------------//
}