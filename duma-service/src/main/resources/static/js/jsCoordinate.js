

//-----------------------------//
let startPage = import('/js/jsStartPage.js');
//-----------------------------//
//-----------------------------//

let coordinate = new Vue({
    el: '#coordinate',
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

coordinate.loadPanel();

//----------------------------//