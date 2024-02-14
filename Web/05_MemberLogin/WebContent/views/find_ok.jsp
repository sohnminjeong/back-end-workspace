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
	<h1>회원 검색 결과</h1>
	<% Member login = (Member)request.getAttribute("find"); %>
	로그인에 성공하였습니다.
	<ul>
		<li>아이디 : <%=login.getId() %></li>
		<li>비밀번호 : <%=login.getPassword() %></li>
		<li>이름 : <%=login.getName() %></li>
	</ul>
	<a href="index.jsp">첫 페이지로 이동</a>
</body>
</html>