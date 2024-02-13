<%@page import="com.kh.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% Member login = (Member)session.getAttribute("login"); %>
	
	<ul>
		<li>아이디 : <%=login.getId() %></li>
		<li>비밀번호 : <%=login.getPassword() %></li>
		<li>이름 : <%=login.getName() %></li>
	</ul>
</body>
</html>