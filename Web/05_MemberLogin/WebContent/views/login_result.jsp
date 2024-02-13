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
	<h1><%=login.getId() %>님, 로그인 완료하였습니다.</h1>
</body>
</html>