import addBook from "./components/addBook.js";
import listBook from "./components/listBook.js";
import myHeader from "./components/myHeader.js";

const template = `
    <div id="container">
        <my-header></my-header>
        <add-book v-if="addOK" v-on:add="addBook"></add-book>
        <list-book v-if="listOK" v-bind:books="books"
                                 v-on:remove="removeBook"
                                 v-on:addpage="addOpen"></list-book>
    </div>
`

new Vue({
    el : '#app',
    template : template,
    data : {
        addOK : false,
        listOK : false,
        books : {}
    },
    components : {
        'my-header' : myHeader,
        'add-book' : addBook,
        'list-book' : listBook
    },
    methods : {
        loadData() {
            fetch('AjaxBookList.do')
            .then(response => response.json())
            .then (result => {
                this.books = result;
                this.listOpen();
            })
        },
        addOpen() {
            this.addOK = true;
            this.listOK = false;
        },
        listOpen() {
            this.listOK = true;
            this.addOK = false;
        },
        removeBook(id){
            fetch('AjaxBookRemove.do?id='+id)
            .then(resolve=>resolve.json())
            .then(result=>{
                if (result.retCode == "Success") {
                    this.loadData();
                }
                else if(result.retCode == "Fail") {
                    console.log("처리중 에러");
                }
                else {
                    console.log("잘못된 코드 반환");
                }
            });
        },
        addBook(id, name, writer, company, price) {
            let url = 'AjaxBookInsert.do';
            let payload = 'id='+id+'&name='+name+'&writer='+writer+'&company='+company+'&price='+price;
            fetch(url, {
                method :'POST',
                headers : {'Content-Type': 'application/x-www-form-urlencoded'},
                body : payload
            })
            .then(resolve => resolve.json())
            .then(result=>{
                if(result.retCode == "Success") {
                    this.loadData();
                }
                else {
                    console.log("실패");
                }
            });
        }
    },
    created : function() {
		this.loadData();
    }
})