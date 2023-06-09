<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록</title>
<link href="${pageContext.request.contextPath}/assets/css/mysite.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/assets/css/guestbook.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/assets/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css">
<!-- J쿼리 -->
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery/jquery-1.12.4.js"></script>
<!-- 부트스트랩 -->
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/bootstrap/js/bootstrap.js"></script>
</head>

<body>
	<div id="wrap">
		<c:import url="/WEB-INF/views/include/header.jsp"></c:import>
		<!-- //header -->
		<c:import url="/WEB-INF/views/include/nav.jsp"></c:import>
		<!-- //nav -->

		<div id="aside">
			<h2>방명록</h2>
			<ul>
				<li>일반방명록</li>
				<li>ajax방명록</li>
			</ul>
		</div>
		<!-- //aside -->

		<div id="content">
			
			<div id="content-head">
            	<h3>일반방명록</h3>
            	<div id="location">
            		<ul>
            			<li>홈</li>
            			<li>방명록</li>
            			<li class="last">일반방명록</li>
            		</ul>
            	</div>
                <div class="clear"></div>
            </div>
            <!-- //content-head -->

			<div id="guestbook">				
					<table id="guestAdd">
						<colgroup>
							<col style="width: 70px;">
							<col>
							<col style="width: 70px;">
							<col>
						</colgroup>
						<tbody>
							<tr>
								<th><label class="form-text" for="input-uname">이름</label></th>
								<td><input id="input-uname" type="text" name="name"></td>
								<th><label class="form-text" for="input-pass">패스워드</label></th>
								<td><input id="input-pass" type="password" name="password"></td>
							</tr>
							<tr>
								<td colspan="4"><textarea name="content" cols="72" rows="5"></textarea></td>
							</tr>
							<tr class="button-area">
								<td colspan="4"><button type="submit" id="btnSubmit">등록</button></td>
							</tr>
						</tbody>
						
					</table>
					<!-- //guestWrite -->
				<div id="guestbookListArea">
					<c:forEach items="${guestList}" var="listVo">
					<table id="t-${listVo.no}" class="guestRead">
						<colgroup>
							<col style="width: 10%;">
							<col style="width: 40%;">
							<col style="width: 40%;">
							<col style="width: 10%;">
						</colgroup>
						<tr>
							<td>${listVo.no}</td>
							<td>${listVo.name}</td>
							<td>${listVo.reg_date}</td>
							<td>
								<button type="button" class="btn btn-default btn-sm deletebtn" data-delno="${listVo.no}" >삭제</button></td>
						</tr>
						<tr>
							<td colspan=4 class="text-left">${listVo.content}</td>
						</tr>
					</table>
					</c:forEach>
				</div>
				<!-- //guestRead -->				
			</div>
			<!-- //guestbook -->
		</div>
		<!-- //content  -->
		<div class="clear"></div>
		<c:import url="/WEB-INF/views/include/footer.jsp"></c:import>
		<!-- //footer -->

	</div>
	<!-- //wrap -->

<!-- 삭제폼 모달창 -->
<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">방명록 삭제</h4>
      </div>
      <div class="modal-body">
        비밀번호 : <input type="password" id="modalPassWord" name="password"><br>
        <input id="modalNo" type="text" name="no">
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
        <button id="modalDeletebtn"  type="button" class="btn btn-danger">삭제</button>
      </div>
    </div>
  </div>
</div>


</body>
<script type="text/javascript">
//모달창 AjAX 연동
$("#modalDeletebtn").on("click",function(){
	console.log("모달창 삭제버튼 클릭");
	
	//AJAX 데이터전달
	//변수 선언
	var passwd = $("#modalPassWord").val();
	var no = $("#modalNo").val();
	
	console.log(passwd,no);
	
	var guestVo = {
			password : passwd,
			no : no
	};
	console.log(guestVo);
	
	$.ajax({			
		url : "${pageContext.request.contextPath}/api/guestbook/remove",		
		type : "post",
		/* contentType : "application/json"*/
		data : guestVo,

		dataType : "json",
		success : function(jsonResult){
			var id = "t-"+guestVo.no;
			
			console.log(jsonResult);
			/*성공시 처리해야될 코드 작성*/
			
			if(jsonResult.data>0) {//처리성공					
				$("#"+id).remove();
				$('#myModal').modal('hide');
					
			}else {//오류처리
				alert("비밀번호가 틀렸습니다.")
			}
		},
		error : function(XHR, status, error) {
			console.error(status + " : " + error);
		}			
	});
	console.log("test입니다." + guestVo.no);	
});


//삭제 모달창 호출버튼 클릭
$("#guestbookListArea").on("click",".deletebtn",function(){
	console.log("삭제버튼 클릭");
	
	//초기화
	$("#modalPassWord").val("");
	$("#modalNo").val("");
	
	//게스트북 No. 호출
	//data("no")
	var $thisDelNo = $(this).data("delno");
	console.log($thisDelNo);
	
	$("#modalNo").val($thisDelNo);		
	
	//모달창 호출
	$('#myModal').modal('show'); 
	
});


//글작성 이벤트 설정(ajax) 
$("#btnSubmit").on("click",function(){
	console.log("등록버튼 작동");
	//변수 설정
	var boardVo = {
		name : $("[name='name']").val(),
		password : $("[name='password']").val(),
		content : $("[name='content']").val()	
	};
	console.log(boardVo);
	$.ajax({			
		url : "${pageContext.request.contextPath}/api/guestbook/add",		
		type : "post",
		/*contentType : "application/json"*/
		data : boardVo,

		dataType : "json",
		success : function(jsonResult){
			console.log(jsonResult);
			/*성공시 처리해야될 코드 작성*/
			
			if(jsonResult.result=="success") {//처리성공					
					render(jsonResult.data);
					console.log("성공");
					
					$("[name='name']").val("");
					$("[name='password']").val("");
					$("[name='content']").val("");
					
					
			}else {//오류처리
				var msg = jsonResult.failMsg;
				alter(msg);				
			}
		},
		error : function(XHR, status, error) {
			console.error(status + " : " + error);
		}			
	});			
});	
	//방명록 리스트 랜더링
	function render(guestBookVo) {
		var str = "";
		str += '<table id="t-' + guestBookVo.no +  '" + class="currentGuestRead">';
		str += '	<colgroup>';
		str += '		<col style="width: 10%;">';
		str += '		<col style="width: 40%;">';
		str += '		<col style="width: 40%;">';
		str += '		<col style="width: 10%;">';
		str += '	</colgroup>';
		
		str += '	<tr>';
		str += '		<td>'+ guestBookVo.no + '</td>';
		str += '		<td>'+ guestBookVo.name + '</td>';
		str += '		<td>'+ guestBookVo.reg_date + '</td>';
		str += '		<td><button type="button" class="btn btn-default btn-sm deletebtn" data-delno="'+guestBookVo.no+'">삭제</button></td>';
		str += '	</tr>';
		
		str += '	<tr>';
		str += '	<td colspan=4 class="text-left">'+ guestBookVo.content + '</td>';
		str += '	</tr>';
		str += '</table>';
		str += '<br>';
		
		$("#guestbookListArea").prepend(str);	
	}
</script>
</html>