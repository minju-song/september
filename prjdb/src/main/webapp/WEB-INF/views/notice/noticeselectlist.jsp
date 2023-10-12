<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link href="https://hangeul.pstatic.net/hangeul_static/css/nanum-square-round.css" rel="stylesheet">
<style>
	#div {
		font-family: 'NanumSquareRound';
	}
    table th, td {
        text-align: center;
    }
</style>
</head>
<body>
<div align="center" id="div">
    <jsp:include page="../menu/header.jsp"/>
    <div>
        <h2>게시글 목록</h2>
    </div>
    <div>
        <form id="search">
            <table border="1">
                <tr><td>
                    <label for="key">Choose a key:</label>
                    <select id="key" name="key">
                        <option value="title">제목</option>
                        <option value="subject">내용</option>
                        <option value="writer">작성자</option>
                    </select>
                    <input type="text" name="val" id="val" onkeydown="enterKey(event)">&nbsp;&nbsp;
                    <input type="button" class="btn btn-info" id="btn" value="검색" onclick="searchList()">
                </td></tr>
            </table>
        </form>
    </div>
    <br>
    <div>
        <table border="1" id="listtable">
            <thead>
                <tr>
                    <th width="50"> 순번 </th>
                    <th width="100"> 이미지 </th>
                    <th width="250"> 제목 </th>
                    <th width="100"> 작성자 </th>
                    <th width="100"> 작성일자 </th>
                    <th width="50"> 조회수 </th>
                    <th width="100"> 첨부파일 </th>
                </tr>
            </thead>
            <tbody id="tlist">
            	<c:choose>
            		<c:when test="${empty notices }">
            			<tr>
            				<td colspan="7" align="center"> 데이터가 존재하지 않습니다. </td>
            			</tr>
            		</c:when>
            		<c:otherwise>
	            		<c:forEach items="${notices }" var="n">
			                <tr onmouseover="this.style.background='#C8FE2E'"
                            onmouseout="this.style.background='#FFFFFF'"
                            onclick="noticeselect(${n.noticeId})">
			                    <td align="center">${n.noticeId }</td>
			                    <td align="center">
                                    <img src="attech/notice/${n.noticeThumb } " height="50px"/>
                                </td>
			                    <td>${n.noticeTitle }</td>
			                    <td align="center">${n.noticeWriterName }</td>
			                    <td align="center">${n.noticeDate }</td>
			                    <td align="center">${n.noticeHit }</td>
			                    <td align="center">${n.noticeAttech }</td>
			                </tr>
		                 </c:forEach>
                	</c:otherwise>
                </c:choose>     
            </tbody>
        </table>
    </div><br>
    <div>
    <c:if test="${not empty id }">
    	<button type="button" class="btn btn-primary" onclick="location.href='noticewriteform.do'">글쓰기</button>
    </c:if>
    <form id="sform" action="noticeselect.do" method="post">
        <input type="hidden" id="noticeId" name="noticeId">
    </form>    
</div>
</div>
<script type="text/javascript">
    function noticeselect(id) {
        let form = document.getElementById("sform");
        form.noticeId.value = id;
        form.submit();
    }
    function searchList() { //ajax post방식
        let form = document.getElementById("search");
        let key = form.key.value;
        let val = form.val.value;
        // const formData = new FormData(form); //자바스크립트 formdata class
        // let payload = formData; //변수에 폼 객체를 한번 더 넣어줌 다이렉트로 폼데이터 처리해도 되지만 자바프로그램이 인식을 잘못함(스프링은 인식함)
        let payload = "key="+key+"&val="+val;
        let url = "ajaxNoticeSearch.do";
        fetch(url,{
            method: "POST",
            headers: {'Content-Type': 'application/x-www-form-urlencoded'},
            body: payload
        }).then(response=>response.json()) //결과를 json으로 받음 //결과받는 콜백함수
          .then(json=>htmlViews(json)); //처리하는 콜백함수
    }
    
    function htmlViews(datas) {
        document.querySelector('#tlist').remove(); //본문에서 tbody 삭제
        const tbody = document.createElement('tbody');
        tbody.setAttribute('id','tlist');
        tbody.innerHTML = datas.map(data=>htmlConvert(data)).join('');
        document.querySelector('#listtable').appendChild(tbody);
    }

    function htmlConvert(n) {
        if(n.noticeAttech == null) { //첨부파일이 존재하지 않으면 null대신
            n.noticeAttech = '';
        }
        return `
        <tr onmouseover="this.style.background='#C8FE2E'"
            onmouseout="this.style.background='#FFFFFF'"
            onclick="noticeselect(\${n.noticeId})">
			    <td align="center">\${n.noticeId }</td>
			    <td align="center">
                    <img src="attech/notice/\${n.noticeImage }" height="50px"/>
                </td>
			    <td>\${n.noticeTitle }</td>
			    <td align="center">\${n.noticeWriterName }</td>
			    <td align="center">\${n.noticeDate }</td>
			    <td align="center">\${n.noticeHit }</td>
			    <td align="center">\${n.noticeAttech }</td>
		</tr>
        `
    }

    function enterKey(e) {
        if(e.keyCode == 13) {
            document.getElementById("btn").focus();
        }
    }
    
</script>
</body>
</html>