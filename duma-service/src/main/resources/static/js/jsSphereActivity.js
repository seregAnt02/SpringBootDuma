
//-----------------------------//
let startPage = import('/js/jsStartPage.js');
//-----------------------------//
//-----------------------------//

let price = new Vue({
    el: '#price',
    data: {
        rows: [
        ],
        login: 'abc',
        user: ''
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

price.loadPanel();

//----------------------------//