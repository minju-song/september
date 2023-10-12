<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/menu.css" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
</head>
<body>
	<nav id="topMenu">
		<ul>
			<li><a class="menuLink" href="home.do">Home</a></li>
			<li><a class="menuLink" href="#">Book</a></li>
			<li><a class="menuLink" href="noticeselectlist.do">Content</a></li>
			<c:if test="${empty id }">
			<li><a class="menuLink" href="memberjoinform.do">Join</a></li>
			<li><a class="menuLink" href="memberloginform.do">Login</a></li>
			</c:if>
			<c:if test="${not empty id }">
			<li><a class="menuLink" href="memberlist.do">Member</a></li>
			<li><a class="menuLink" href="#">MyPage</a></li>
			<li><a class="menuLink" href="memberlogout.do">Logout</a></li>
			<li id="name">${name }님 접속중</li>
			</c:if>
		</ul>
	</nav>
</body>
</html>