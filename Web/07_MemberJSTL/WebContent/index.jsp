<%@page import="com.kh.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- requstScope가 sessionScope보다 우선적임! but 여기선 requestScope가 없기 때문에 sessionScope 생략하여 login만 써도 가능 --%>
	<%-- 'login == null'이 'empty login'과 같은 뜻 --%>
	<%-- 
		== : eq,
		!= : ne,
		==null : empty,
		!=null : not empty 
	--%>
	<h1>회원 관리 기능</h1>
	<ul>
		<c:choose>
			<c:when test="${empty login}">	
				<li><a href="views/register.html">회원가입</a></li>
				<li><a href="views/login.html">로그인</a></li>
			</c:when>
		 
			<c:otherwise>
				<li><a href="views/search.html">회원검색</a></li>
				<li><a href="AllMemberServlet">전체회원보기</a></li>
				<li><a href="LogoutServlet">로그아웃</a></li>
			</c:otherwise>
		 
		</c:choose>
	</ul>
</body>
</html>