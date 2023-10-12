<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://hangeul.pstatic.net/hangeul_static/css/nanum-square-round.css" rel="stylesheet">
<style>
	#div {
		font-family: 'NanumSquareRound';
	}

	table td {
		text-align: center;
		padding: 5px;
	}
	table th {
		text-align: center;
		padding: 5px;
	}
</style>
</head>
<body>
<div align="center" id="div">
	<jsp:include page="../menu/header.jsp"/>
	<div><h1>&#127802;게시글 상세보기&#127802;</h1></div>
	<div>
	<div>
				<table border="2">
					<tr>
						<th width="100">작성자</th>
						<td width="150">${n.noticeWriterName }</td>
						<th width="100">작성일자</th>
						<td width="150" align="center"> ${n.noticeDate }</td>
						<th width="100">조회수</th>
						<td width="50" align="center"> ${n.noticeHit +1}</td>
					</tr>
					<tr>
						<th>이미지</th>
						<td colspan="5">
							<img height="200px" src="attech/notice/${n.noticeImage }">
						</td>
					</tr>
					<tr>
						<th>제 목</th>
						<td colspan="5">${n.noticeTitle }</td>
					</tr>
					<tr>
						<th>내 용</th>
						<td colspan="5">
							<textarea rows="10" cols="80">${n.noticeSubject }</textarea>
						</td>
					</tr>
					<tr>
						<th>첨부파일</th>
						<td colspan="5">${n.noticeAttech }</td>
					</tr>
				</table>
			</div>
		</div>
	<h3>&#127799;댓글목록&#127799;</h3>
	<table border="2">
		<thead>
			<th>번호</th><th>내용</th><th>작성자</th><th>작성날짜</th><th>삭제버튼</th>
		</thead>
		<tbody id="replyList">
		</tbody>
	</table>
	<br><br>

	<!-- 등록화면 -->
	<table border="1">
		<tr>
			<th>댓글내용</th><td><input type="text" name="content"></td>
		</tr>
		<tr>
			<th>작성자</th><td><input type="text" name="writer"></td>
		</tr>
		<tr>
			<td colspan="2">
				<button id="addReply" >댓글등록</button>
			</td>
		</tr>
	</table>
</div>
<!-- modal 창 -->
<style>
	.modal {
  display: none; /* Hidden by default */
  position: fixed; /* Stay in place */
  z-index: 1; /* Sit on top */
  padding-top: 100px; /* Location of the box */
  left: 0;
  top: 0;
  width: 100%; /* Full width */
  height: 100%; /* Full height */
  overflow: auto; /* Enable scroll if needed */
  background-color: rgb(0,0,0); /* Fallback color */
  background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
}

/* Modal Content */
.modal-content {
  background-color: #fefefe;
  margin: auto;
  padding: 20px;
  border: 1px solid #888;
  width: 80%;
}

/* The Close Button */
.close {
  color: #aaaaaa;
  float: right;
  font-size: 28px;
  font-weight: bold;
}

.close:hover,
.close:focus {
  color: #000;
  text-decoration: none;
  cursor: pointer;
}
</style>
<div id="myModal" class="modal">

	<!-- Modal content -->
	<div class="modal-content">
	  <span class="close">&times;</span>
	  <p>23</p>
		<p><input class="content"></p>
		<p><button id="editBtn">수정</p>
	</div>
  
  </div>

<script src='js/reply.js'></script>
<script>
	const fields = ['replyId', 'reply', 'replyer', 'replyDate'];
	const replyObj = new Reply();
	replyObj.showInfo();


	let noticeId = "${n.noticeId }";

	replyObj.replyList(noticeId, function (data) {
		const fields = ['replyId', 'reply', 'replyer', 'replyDate'];
		data.forEach(function (reply) {
			let tr = makeTr(reply);
			document.getElementById('replyList').appendChild(tr);
		});
	})

	//댓글정보를 매개값으로 tr요소 생성
	function makeTr (reply) {
			let tr = document.createElement('tr');
			tr.setAttribute('rid', reply.replyId);
			tr.addEventListener('dblclick', showEditForm);
			for (let prop of fields) {
				let td = document.createElement('td');
				if(prop == 'replyDate') {
					td.innerText = replyObj.displayDate(reply[prop]);
				}
				else {
					td.innerText = reply[prop];
				}
				tr.appendChild(td);
			}
			let td = document.createElement('td');
			let btn = document.createElement('button');
			btn.innerText = "삭제";

			btn.addEventListener('click', deleteReplyFnc );
			td.appendChild(btn);
			tr.appendChild(td);
			// document.getElementById('replyList').appendChild(tr);
			return tr;
		}




	//댓글 삭제 이벤트 핸들러
	function deleteReplyFnc(e) {
		let rid = e.target.parentElement.parentElement.getAttribute('rid');
		replyObj.replyRemove(rid, function(result) {
			if (result.retCode == "Success") {
				e.target.parentElement.parentElement.remove();
				alert("댓글이 삭제되었습니다.");
			}
			else if(result.retCode == "Fail") {
				alert("처리중 에러");
			}
			else {
				alert("잘못된 코드 반환");
			}
		})
	}



		//내가 쓴 코드
		// for(let i = 0; i< data.length; i++) {
		// 	let replyId = data[i].replyId;
		// 	let reply = data[i].reply;
		// 	let replyer = data[i].replyer;
		// 	let replyDate = data[i].replyDate;

		// 	const replys = {
		// 		replyId, reply, replyer, replyDate
		// 	}

		// 	let tr = document.createElement('tr');
			

		// 	for(let prop in replys) {
		// 		let td = document.createElement('td');
		// 		td.innerText = replys[prop];
		// 		tr.appendChild(td);
		// 	}
		// 	document.getElementById('replyList').appendChild(tr);
		// }
	
		//댓글등록 이벤트
		replyObj.replyAdd
		document.querySelector('#addReply').addEventListener('click', function(e) {
			let content = document.querySelector('input[name=content]').value;
			let writer = document.querySelector('input[name=writer]').value;
			const r = {nid:noticeId, replyer:writer, reply:content};
			
			replyObj.replyAdd(r, function(data){
				if(data.retCode == "Success") {
					let tr = makeTr(data.data);
					document.getElementById('replyList').appendChild(tr);
					fieldInit();
				}
				else if (data.retCode == "Fail" ) {
					alert("처리 중 에러");
				}
				else {
					alert("알 수 없는 반환코드");
				}
			})
		})

		function fieldInit() {
			document.querySelector('input[name=content]').value = '';
			document.querySelector('input[name=writer]').value = '';
		}

		//수정화면 오픈
		function showEditForm(e) {
			var modal = document.getElementById("myModal");
			modal.style.display = "block";
			console.log(this);
			let rid = this.getAttribute('rid');
			replyObj.replySearch(rid, function(data) {
				console.log(data);
				document.querySelector('#myModal p').innerText = rid;
				
				document.querySelector('#myModal input.content').value = data.reply;
			})


		}

		//모달창 닫기
		document.querySelector('span.close').addEventListener('click', function(){
			var modal = document.getElementById("myModal");
			modal.style.display = "none";
		})


		// When the user clicks anywhere outside of the modal, close it
		window.onclick = function(event) {
			var modal = document.getElementById("myModal");
			if (event.target == modal) {
				modal.style.display = "none";
			}
		}

		document.querySelector('#editBtn').addEventListener('click', editReplyHandler);

		function editReplyHandler(e) {
			let rid = document.querySelector('#myModal p').innerText;
			let content = document.querySelector('#myModal input.content').value;

			
			replyObj.replyModify({rid : rid, reply : content} , function(data) {
				if (data.retCode == 'Success') {
					let oldTr = document.querySelector('tr[rid="'+rid+'"]');
					let newTr = makeTr(data.data);
					document.querySelector('#replyList').replaceChild(newTr, oldTr);
				}
				else {
					alert('처리 중 오류');
				}
				var modal = document.getElementById("myModal");
				modal.style.display = "none";
			});
		}

</script>

</body>
</html>