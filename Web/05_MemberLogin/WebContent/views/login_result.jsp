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
	<% Member login = (Member)session.getAttribute("login"); 
		if(login!=null){%>
		
			<h1>로그인 정보</h1>
			<ul>
				<li>아이디 : <%=login.getId() %></li>
				<li>비밀번호 : <%=login.getPassword() %></li>
				<li>이름 : <%=login.getName() %></li>
			</ul>
				<a href="/index.jsp">첫 페이지로 이동</a>
	<%	} else { %>
			<h2>로그인 실패..! 다시 로그인 해주세요</h2>
			<a href="login.html">로그인 페이지로 이동</a>
	<%	} %>
	
</body>
</html>