<%@page import="com.kh.model.vo.Member"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border=1>
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
		</tr>
		<% ArrayList<Member> list = (ArrayList<Member>)request.getAttribute("list");
			for(Member m : list) { %>
		<tr>
			<td><%=m.getId() %></td>
			<td><%=m.getPassword() %></td>
			<td><%=m.getName() %></td>
		</tr>
		<% } %>
	</table>
</body>
</html>