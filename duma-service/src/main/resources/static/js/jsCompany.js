
//-----------------------------//
let startPage = import('/js/jsStartPage.js');
//-----------------------------//
//-----------------------------//

let company = new Vue({
    el: '#company',
    data: {
        rows: [
        ],
        login: 'abc'
    },
    methods: {
        loadPanel: function (){
            startPage.then(
                r => {
                    r.startPage.loadPanel();
                }
            )
        },
        eventPanel: function (){
            startPage.then(
                r => {
                    r.startPage.eventPanel();
                }
            )
        }
    },
});

//----------------------------//
/*const formLoad = document.getElementById("form-load");
const idButtonPanel = document.getElementById("idButtonPanel");*/
//----------------------------//

startPage.then(r => {
    r.startPage.loadPanel();
})

//company.setMarginTop(idButtonPanel, formLoad);
//----------------------------//