
//-----------------------------//
let startPage = import('/js/jsStartPage.js');
//-----------------------------//
//-----------------------------//

let company = new Vue({
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

startPage.then(r => {
    r.startPage.loadPanel();
})

//----------------------------//