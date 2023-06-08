<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href="${pageContext.request.contextPath }/assets/css/mysite.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath }/assets/css/gallery.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath }/assets/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css">

<script type="text/javascript" src="${pageContext.request.contextPath }/assets/js/jquery/jquery-1.12.4.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/assets/bootstrap/js/bootstrap.js"></script>

</head>


<body>
	<div id="wrap">

		<c:import url="/WEB-INF/views/include/header.jsp"></c:import>
		<!-- //header -->
		<c:import url="/WEB-INF/views/include/nav.jsp"></c:import>
		<!-- //nav -->
		<c:import url="/WEB-INF/views/include/asideBoard.jsp"></c:import>
		<!-- //게시판 aside -->
		<div id="content">

			<div id="content-head">
				<h3>갤러리</h3>
				<div id="location">
					<ul>
						<li>홈</li>
						<li>갤러리</li>
						<li class="last">갤러리</li>
					</ul>
				</div>
				<div class="clear"></div>
			</div>
			<!-- //content-head -->


			<div id="gallery">
				<div id="list">
				<c:choose>
					<c:when test="${sessionScope.successUser!=null}">
						<button id="btnImgUpload">이미지올리기</button>
					</c:when>
				</c:choose>
					<div class="clear"></div>


					<ul id="viewArea">

						<!-- 이미지반복영역 -->
						<c:forEach begin="1" end="15" items="${requestScope.galleryList}" var="galleryVo">
						<li>
							<div class="view" data-no="${galleryVo.no}">
								<img class="imgItem" src="${pageContext.request.contextPath}/upload/${galleryVo.saveName}">
								<div class="imgWriter">
									작성자: <strong>${galleryVo.userName}</strong>							
								</div>
							</div>
						</li>
						</c:forEach>
						<!-- 이미지반복영역 -->


					</ul>
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



	<!-- 이미지등록 팝업(모달)창 -->
	<div class="modal fade" id="addModal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">이미지등록</h4>
				</div>

				<form method="post" action="${pageContext.request.contextPath }/gallery/upload" enctype="multipart/form-data">
					<div class="modal-body">
						<div class="form-group">
							<label class="form-text">글작성</label> <input id="addModalContent" type="text" name="content" value="">
						</div>
						<div class="form-group">
							<label class="form-text">이미지선택</label> <input id="file" type="file" name="file" value="">						
						</div>
					</div>
					<div class="modal-footer">
						<button type="submit" class="btn" id="btnUpload">등록</button>
					</div>
				</form>


			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->



	<!-- 이미지보기 팝업(모달)창 -->
	<div class="modal fade" id="viewModal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">이미지보기</h4>
				</div>
				<div class="modal-body">

					<div class="formgroup">
						<img id="viewModelImg" src="">
						<!-- ajax로 처리 : 이미지출력 위치-->
						
					</div>

					<div class="formgroup">
						<p id="viewModelContent"></p>
					</div>

				</div>
				<form method="" action="">
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
						<button type="button" class="btn btn-danger" id="btnDel">삭제</button>
					</div>


				</form>

			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->


</body>

<script type="text/javascript">
$("#btnImgUpload").on("click",function(){
	console.log("이미지등록 클릭");	
	
	//모달창 호출
	$('#addModal').modal('show'); 
	
});
$(".view").on("click",function(){
	console.log("이미지보기 클릭");	
	var $thisNo = $(this).data("no");
	console.log($thisNo);
	//galleryvo객체 가져오기
	$.ajax({			
		url : "${pageContext.request.contextPath}/gallery/view",		
		type : "post",
		/* contentType : "application/json" */
		data : {no : $thisNo},

		dataType : "json",
		success : function(jsonResult){
			console.log(jsonResult);
			/*성공시 처리해야될 코드 작성*/
			if(jsonResult.data!=null) {//처리성공	
												
				$('#viewModelImg').attr("src",'${pageContext.request.contextPath}/upload/' + jsonResult.data.saveName );				
				$('#viewModelContent').html(jsonResult.data.content);
				$('#viewModal').modal('show');	
			}else {//오류처리
				alert("오류확인요망")
			}
		},
		error : function(XHR, status, error) {
			console.error(status + " : " + error);
		}			
	});			
});	


</script>



</html>

