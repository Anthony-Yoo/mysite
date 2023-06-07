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
					방명록 리스트 출력 영역
				</div>
				<!-- //guestRead -->				
			</div>
			<!-- //guestbook -->
		</div>
		<!-- //content  -->
		<div class="clear"></div>
		<!-- //footer -->
		<c:import url="/WEB-INF/views/include/footer.jsp"></c:import>
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
//DOM생성 후 그리기 전
$(document).ready(function(){
	
		fetchList();
		
});

function fetchList(){
	$.ajax({			
		url : "${pageContext.request.contextPath}/api/guestbook/list",		
		type : "post",
		/* contentType : "application/json"
		data : guestVo,*/

		dataType : "json",
		success : function(jsonResult){
			console.log(jsonResult);
			/*성공시 처리해야될 코드 작성*/
			
			var guestList = jsonResult.data;
			
			for(var i =1; i<guestList.length;i++) {
				render(guestList[i],"down");
			}
	
		},
		error : function(XHR, status, error) {
			console.error(status + " : " + error);
		}	
		
		});
}
//방명록 저장 버튼 클릭할때
$("#btnSubmit").on("click",function(){
	console.log("등록버튼 작동");
	//변수 설정
	var boardVo = {
		name : $("[name='name']").val(),
		password : $("[name='password']").val(),
		content : $("[name='content']").val()	
	};
	var str =JSON.stringify(boardVo); 
	console.log(str);
	
	$.ajax({			
		url : "${pageContext.request.contextPath}/api/guestbook/add2",		
		type : "post",
		contentType : "application/json",
		data : str,

		dataType : "json",
		success : function(jsonResult){
			console.log(jsonResult);
			/*성공시 처리해야될 코드 작성*/
			
			if(jsonResult.result=="success") {//처리성공					
					render(jsonResult.data,"up");
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
function render(guestBookVo,dir) {
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
	
	if(dir =="up"){		
		$("#guestbookListArea").prepend(str);	
	}else if(dir =="down") {
		$("#guestbookListArea").append(str);
		
	}else { 
		console.log("방향오류")
	}
}


</script>
</html>