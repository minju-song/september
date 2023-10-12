<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
	<jsp:include page="../menu/header.jsp"/>
		<div><h3>회원목록</h3></div>
		<div>
			<c:forEach items="${members }" var="m">
				아이디: ${m.memberId } 이름: ${m.memberName } 가입일: ${m.memberEnterDate }<br>
			</c:forEach>
		</div>
	</div>
</body>
</html>