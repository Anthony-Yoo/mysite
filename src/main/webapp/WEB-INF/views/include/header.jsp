<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="header">
	<h1><a href="${pageContext.request.contextPath}/index">MySite </a></h1>
	<c:choose>
		<c:when test="${sessionScope.successUser==null}">
			<ul>
				<li><a href="${pageContext.request.contextPath}/user/loginForm">로그인</a></li>
				<li><a href="${pageContext.request.contextPath}/user/joinForm">회원가입</a></li>
			</ul>
		</c:when>
		<c:when test="${sessionScope.successUser!=null}">
			<ul>
				<li>${sessionScope.successUser.name}님 안녕하세요^^</li>
				<li><a href="${pageContext.request.contextPath}/user/logout">로그아웃</a></li>
				<li><a href="${pageContext.request.contextPath}/user/modifyForm">회원정보수정</a></li>
			</ul>
		</c:when>
	</c:choose>			
</div>
