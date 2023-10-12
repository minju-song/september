/**
 * 
 */

 class Book {
	 showInfo() {
		 console.log("실행");
	 }
	 
	 bookList(callback) {
		 fetch('AjaxBookList.do')
		 .then(resolve=>resolve.json())
		 .then(result=>callback(result));
	 }
	 
	 bookInsert(book = {id:'a', name:'a', writer:'a', company:'a', price:0}, callback) {
		 let url = 'AjaxBookInsert.do';
		 let payload = 'id='+book.id+'&name='+book.name+'&writer='+book.writer+'&company='+book.company+'&price='+book.price;
		 fetch(url, {
			 method :'POST',
			 headers : {'Content-Type': 'application/x-www-form-urlencoded'},
			 body : payload
		 })
		 .then(resolve => resolve.json())
		 .then(result=>callback(result));
	 }
	 
	 bookRemove(bookId, callback) {
		 fetch('AjaxBookRemove.do?id='+bookId)
        .then(resolve=>resolve.json())
        .then(result=>callback(result));
	 }
 }