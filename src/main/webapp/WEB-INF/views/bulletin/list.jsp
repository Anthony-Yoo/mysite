<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<link href="${pageContext.request.contextPath}/assets/css/mysite.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/assets/css/board.css" rel="stylesheet" type="text/css">

</head>

<body>
	<div id="wrap">	
		<c:import url="/WEB-INF/views/include/header.jsp"></c:import>
		<!-- //header -->
		<c:import url="/WEB-INF/views/include/nav.jsp"></c:import>
		<!-- //nav -->
		<div id="aside">
			<h2>게시판</h2>
			<ul>
				<li><a href="">일반게시판</a></li>
				<li><a href="">댓글게시판</a></li>
			</ul>
		</div>
		<!-- //aside -->

		<div id="content">

			<div id="content-head">
				<h3>게시판</h3>
				<div id="location">
					<ul>
						<li>홈</li>
						<li>게시판</li>
						<li class="last">일반게시판</li>
					</ul>
				</div>
				<div class="clear"></div>
			</div>
			<!-- //content-head -->

			<div id="board">
				<div id="list">
					<form action="${pageContext.request.contextPath}/bulletin/search" method="get">
						<div class="form-group text-right">
							<input type="text" name="keyword" placeholder="제목/글쓴이 검색">
							<button type="submit" id=btn_search>검색</button>
						</div>
					</form>
					<!-- 리스트반복 시작-->								
					<c:forEach items="${requestScope.boardList}" var="bulletinVo">			
					<table>					
						<thead>
							<tr>
								<th>번호</th>
								<th>제목</th>
								<th>글쓴이</th>
								<th>조회수</th>
								<th>작성일</th>
								<th>관리</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>${bulletinVo.no}</td>
								<td><a href="${pageContext.request.contextPath}/bulletin/viewForm?no=${bulletinVo.no}">${bulletinVo.title}</a></td>
								<td>${bulletinVo.name}</td>
								<td>${bulletinVo.hit}</td>
								<td>${bulletinVo.reg_date}</td>
						<c:choose>
							<c:when test="${sessionScope.successUser.name eq bulletinVo.name}">		
								<td><a href="${pageContext.request.contextPath}/bulletin/delete?no=${bulletinVo.no}">[삭제]</a></td>
							</c:when>
						</c:choose>			
							</tr>							
						</tbody>					 
					</table>
					</c:forEach>	

					<!-- 리스트반복 종료 -->	
					<div id="paging">
						<ul>
							<li><a href="">◀</a></li>
							<li><a href="">1</a></li>
							<li><a href="">2</a></li>
							<li><a href="">3</a></li>
							<li><a href="">4</a></li>
							<li class="active"><a href="">5</a></li>
							<li><a href="">6</a></li>
							<li><a href="">7</a></li>
							<li><a href="">8</a></li>
							<li><a href="">9</a></li>
							<li><a href="">10</a></li>
							<li><a href="">▶</a></li>
						</ul>
						
						
						<div class="clear"></div>
					</div>
					<c:choose>
							<c:when test="${sessionScope.successUser!=null}">
								<a id="btn_write" href="${pageContext.request.contextPath}/bulletin/writeForm">글쓰기</a>
							</c:when>
					</c:choose>					
				</div>
				<!-- //list -->
			</div>
			<!-- //board -->
		</div>
		<!-- //content  -->
		<div class="clear"></div>

		<c:import url="/WEB-INF/views/include/footer.jsp"></c:import>
		<!-- //footer -->
	</div>
	<!-- //wrap -->

</body>

</html>
