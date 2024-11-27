
export let startPage = new Vue({
    el: '#startPage',
    data: {
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

                    const panelHeaderRef = document.getElementsByClassName("panelHeaderRef");


                    for (let i = 0; i < panelHeaderRef.length; i++) {
                        panelHeaderRef[i].addEventListener("click",
                            () => EventAnimationsClick(panelHeaderRef[i]));
                    }

                }
            );
        },
        eventPanel: function (){
            idButtonPanel.classList.remove("side-button-off");
            idButtonPanel.classList.add("side-button-on");
            buttonClickPanel().then( r => {
                    setTimeout(() => {
                        idButtonPanel.classList.remove("side-button-on");
                        idButtonPanel.classList.add("side-button-off");
                    }, 75);

                }
            );


        },
        setMarginTop: function (idButton, idPanel){
            let sumOffset = idPanel.offsetTop - (idButton.offsetTop + 35) ;
            idPanel.style.marginTop = (-sumOffset) + "px";
        }
    },
});


//----------------------------//
let hostname = window.location.hostname;
const formLoad = document.getElementById("form-load");
const idButtonPanel = document.getElementById("idButtonPanel");
const idMeltingLines = document.getElementById("idMeltingLines");
//----------------------------//
//----------------------------//

startPage.loadPanel();


startPage.setMarginTop(idButtonPanel, formLoad);


//startPage.clickPanelHeaderRef();

//----------------------------//


async function buttonClickPanel(){
    if(startPage.panel != null && startPage.sideB != null){
        if(startPage.sideB[0].textContent === "close"){
            startPage.panel.classList.remove("panel-close");
            startPage.panel.classList.add("panel-open");
            startPage.sideB[0].textContent = "open";
        } else {
            startPage.panel.classList.remove("panel-open");
            startPage.panel.classList.add("panel-close");
            startPage.sideB[0].textContent = "close";
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

async function EventAnimationsClick(ref){
    idMeltingLines.removeAttribute("hidden");
}
