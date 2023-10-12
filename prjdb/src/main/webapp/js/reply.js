/**
 * 
 */
console.log('js/reply.js');

class Reply {
    showInfo() {
        console.log("실행");
    }

    //목록조회기능
    replyList(noticeId, callback) {
        // let xhttp = new XMLHttpRequest();
        // xhttp.open('get','AjaxReplyList.do?nid='+noticeId);
        // xhttp.send();
        // xhttp.onload = function(e) {
        //     let data = JSON.parse(xhttp.responseText);
        //     console.log(data);
        //     callback(data);
        // }

        fetch('AjaxReplyList.do?nid='+noticeId) //promise로 반환 (처리중, 완료, 실패)
        .then(resolve=>resolve.json())
        .then(result=>callback(result));
        // .catch(err=>errorcall(err)); 
    }

    //숫자 -> 년,월,일,시간으로 바꿔서 출력
    displayDate(millis) {
		let date = new Date(millis);
		let yyyy = date.getFullYear();
		let mm = ('0'+(date.getMonth()+1)).slice(-2);
		let dd = ('0'+date.getDate()).slice(-2);
		let hh = ('0'+date.getHours()).slice(-2);
		let m = ('0'+date.getMinutes()).slice(-2);

		return yyyy+"-"+mm+"-"+dd+" "+hh+":"+m;
	}

    //get방식
    replyRemove(replyId, callback) {
        // let xhttp = new XMLHttpRequest();
        // xhttp.open('get','AjaxReplyDelete.do?rid='+replyId);
        // xhttp.send();
        // xhttp.onload = function(e) {
        //     let data = JSON.parse(xhttp.responseText);
        //     callback(data);
        // }

        fetch('AjaxReplyDelete.do?rid='+replyId)
        .then(resolve=>resolve.json())
        .then(result=>callback(result));
    }

    //post방식
    replyAdd(reply = {nid:1, replyer:'user', reply:'test'}, callback) {
        // let xhttp = new XMLHttpRequest();
        // xhttp.open('post', 'AjaxReplyAdd.do');
        // xhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
        // xhttp.send('nid='+reply.nid+'&content='+reply.reply+'&writer='+reply.replyer);
        // xhttp.onload = function(e) {
        //     let data = JSON.parse(xhttp.responseText);
        //     callback(data);
        // }

        let url = 'AjaxReplyAdd.do';
        let payload = 'nid='+reply.nid+'&content='+reply.reply+'&writer='+reply.replyer;
        fetch(url, {
            method : 'POST',
            headers : {'Content-Type': 'application/x-www-form-urlencoded'},
            body : payload
        })
        .then(resolve=>resolve.json())
        .then(result=>callback(result));
    }
    
    replySearch(replyId, callback) {
		// let xhttp = new XMLHttpRequest();
		// xhttp.open('get', 'AjaxReplySearch.do?rid='+replyId);
		// xhttp.send();
		// xhttp.onload = function(e) {
		// 	let data = JSON.parse(xhttp.responseText);
		// 	callback(data);
		// }

        fetch('AjaxReplySearch.do?rid='+replyId)
        .then(resolve=>resolve.json())
        .then(result=>callback(result));
	}

    replyModify(reply = {rid:1, reply:'test'}, callback) {
        // let xhttp = new XMLHttpRequest();
        // xhttp.open('post', 'AjaxReplyModify.do');
        // xhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
        // xhttp.send('rid='+reply.rid+'&content='+reply.reply);
        // xhttp.onload = function(e) {
        //     let data = JSON.parse(xhttp.responseText);
        //     console.log(data);
        //     callback(data);
        // }

        let url = 'AjaxReplyModify.do';
        let payload = 'rid='+reply.rid+'&content='+reply.reply;
        fetch(url, {
            method : 'POST',
            headers : {'Content-Type': 'application/x-www-form-urlencoded'},
            body : payload
        })
        .then(resolve=>resolve.json())
        .then(result=>callback(result));

    }
}