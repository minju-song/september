<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://hangeul.pstatic.net/hangeul_static/css/nanum-square-round.css" rel="stylesheet">
<style>
    #container {
        width: 70%;
        margin: 0 auto;
        border: 1px solid black;
        padding: 10px;
        font-family: 'NanumSquareRound';
    }
    .form-group{
        display: flex;
    }
    table {
        border-spacing: 0px 10px;
        border-collapse: separate;
        margin-top: 10px;
    }
    label {
        flex: 1;
        background-color: palevioletred;
        display: inline-block;
        text-align: center;
        font-size: small;
        font-weight: bold;
        line-height: 20px;
    }
    hr{
        border: 0;
        height: 2px;
        background-color: black;
    }
    input {
        flex: 2;
    }
    th {
        width: 150px;
        color: white;
      
    }

    tbody tr{
        border-top: 1px solid black;
        border-bottom: 1px solid black;
        margin-bottom: 10px;
        height: 30px;
    }

    td{
        font-size: small;
        border-top: 1px solid black;
        border-bottom: 1px solid black;
    }

    button {
        width: 70px;
    }
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body id="container">
<hr>

<div style="display: flex;">
    <div style="flex: 3;">
        <form id="frm"> 
            <div class="form-group">
                <label for="id">도서코드</label>
                <input type="text" id="id" name="id">
            </div>           
            <br>
            <div class="form-group">
                <label for="name">도서명</label>
                <input type="text" id="name" name="name">
            </div>
            <br>
            <div class="form-group">
                <label for="writer">저자</label>
                <input type="text" id="writer" name="writer">
            </div>
            <br>
            <div class="form-group">
                <label for="company">출판사</label>
                <input type="text" id="company" name="company">
            </div>
            <br>
            <div class="form-group">
                <label for="price">금액</label>
                <input type="number" id="price" name="price">
            </div>
        </form>
    </div>
    <div style="flex: 1; text-align:center; line-height:80px;">
       <button onclick="insert()">저장</button>
       <br>
       <button onclick="deleteCk()">선택삭제</button>
    </div>
</div>

<div>
    <table style="border: 2px solid black; width: 100%;">
        <thead>
            <tr style="background-color: gray; border: 0;">
                <th><input type="checkbox" id="ckAll" onclick="checkAll()"></th>
                <th>도서코드</th>
                <th>도서명</th>
                <th>저자</th>
                <th>출판사</th>
                <th>가격</th>
                <th>삭제</th>
            </tr>
        </thead>
        <tbody id="bookList" style="text-align:center;">

        </tbody>
    </table>
</div>

<script src="js/book.js"></script>
<script>
    const fields = ['bookId', 'bookName', 'bookWriter', 'bookCompany', 'bookPrice'];
    const bk = new Book();
    bk.showInfo();

    //리스트 불러오기
    bk.bookList(function(data) {
        const fields = ['bookId', 'bookName', 'bookWriter', 'bookCompany', 'bookPrice'];
        data.forEach(function (book) {
			let tr = makeTr(book);
			document.getElementById('bookList').appendChild(tr);
		});
    });

    //전체 선택 및 해제
    function checkAll(){
    console.log($('#ckAll').is(':checked'));
       if($('#ckAll').is(':checked')) $('input[name=ckbox]').prop("checked",true);
       else $('input[name=ckbox]').prop("checked",false);
    }

    //하나라도 달라지면 전체선택 해제
    $(document).on("click", "input:checkbox[name=ckbox]", function(e) {
        var checks = document.getElementsByName('ckbox');
        var checkeds = 0;

        for(var i=0; i<checks.length; i++) {
            var cbox = checks[i];
            if(cbox.checked) {
                checkeds++;
            }
        }

        if(checks.length == checkeds) {
            $('#ckAll').prop("checked", true);
        }
        else {
            $('#ckAll').prop("checked", false);
        }
    })

    
    //tr만들어줌
    function makeTr (book) {
			let tr = document.createElement('tr');
			tr.setAttribute('id', book.bookId);
			// tr.addEventListener('dblclick', showEditForm);
            let td = document.createElement('td');
            let input = document.createElement('input');
            input.setAttribute("type","checkbox");
            input.setAttribute("name","ckbox");
            td.appendChild(input);
            tr.appendChild(td);
			for (let prop of fields) {
				let td = document.createElement('td');
				if(prop == 'bookPrice') {
					td.innerText = book[prop].toString().replace(/\B(?<!\.\d*)(?=(\d{3})+(?!\d))/g, ",")+'원';
				}
				else {
					td.innerText = book[prop];
				}
				tr.appendChild(td);
			}
			td = document.createElement('td');
			let btn = document.createElement('button');
			btn.innerText = "삭제";

			btn.addEventListener('click', deleteBook);
			td.appendChild(btn);
			tr.appendChild(td);
			// document.getElementById('replyList').appendChild(tr);
			return tr;
		}
    
    //선택한 책 삭제
    function deleteCk() {
        
        $('input:checkbox').each(function (index) {
            if($(this).is(":checked")==true){
                console.log($(this).parents()[1].id);
                deleteBooks($(this).parents()[1].id);
            }
        })

        alert("해당 책이 삭제되었습니다.");
    }

    //삭제버튼
    function deleteBook(e) {
        let id = e.target.parentElement.parentElement.getAttribute('id');
        console.log(id+"번 삭제");
        deleteBooks(id);
        alert("해당 책이 삭제되었습니다.");

        // bk.bookRemove(id, function(result) {
		// 	if (result.retCode == "Success") {
		// 		e.target.parentElement.parentElement.remove();
		// 		alert("해당 책이 삭제되었습니다.");
		// 	}
		// 	else if(result.retCode == "Fail") {
		// 		alert("처리중 에러");
		// 	}
		// 	else {
		// 		alert("잘못된 코드 반환");
		// 	}
        // })
        
    }

    //삭제 서블릿 전송
    function deleteBooks(id) {
        bk.bookRemove(id, function(result) {
			if (result.retCode == "Success") {
				// e.target.parentElement.parentElement.remove();
                $('tr').remove(`#`+id);
			}
			else if(result.retCode == "Fail") {
				// alert("처리중 에러");
			}
			else {
				// alert("잘못된 코드 반환");
			}
        })
    }

        //책 추가
        function insert() {
        // console.log("저장버튼 클릭");
        let bookId = document.getElementById("id").value;
        let bookName = document.getElementById("name").value;
        let bookWriter = document.getElementById("writer").value;
        let bookCompany = document.getElementById("company").value;
        let bookPrice = document.getElementById("price").value;
        
        const b = {id:bookId, name:bookName, writer:bookWriter, company:bookCompany, price:bookPrice};
        
        bk.bookInsert(b, function(data) {
            if(data.retCode == "Success") {
                let tr = makeTr(data.data);
                document.getElementById('bookList').appendChild(tr);
				fieldInit();
                console.log(data.data);
            }
            else {
                console.log("실패");
            }
        })

    }

    //초기화
    function fieldInit() {
        document.getElementById("id").value ="";
        document.getElementById("name").value="";
        document.getElementById("writer").value="";
        document.getElementById("company").value="";
        document.getElementById("price").value="";
    }
</script>
</body>
</html>