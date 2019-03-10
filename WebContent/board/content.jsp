<%@page import="com.itbank.model.domain.Board"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
	Board board=(Board)request.getAttribute("board");
%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {
  font-family: Arial, Helvetica, sans-serif;
  background-color: black;
}

* {
  box-sizing: border-box;
}

/* Add padding to containers */
.container {
  padding: 16px;
  background-color: white;
}

/* Full-width input fields */
input[type=text], input[type=password] {
  width: 100%;
  padding: 15px;
  margin: 5px 0 22px 0;
  display: inline-block;
  border: none;
  background: #f1f1f1;
}

input[type=text]:focus, input[type=password]:focus {
  background-color: #ddd;
  outline: none;
}

/* Overwrite default styles of hr */
hr {
  border: 1px solid #f1f1f1;
  margin-bottom: 25px;
}

/* Set a style for the submit button */
.registerbtn {
  background-color: #4CAF50;
  color: white;
  padding: 16px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 10%;
  opacity: 0.9;
}

.registerbtn:hover {
  opacity: 1;
}

/* Add a blue text color to links */
a {
  color: dodgerblue;
}

/* Set a grey background color and center the text of the "sign in" section */
.signin {
  background-color: #f1f1f1;
  text-align: center;
}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="//cdn.ckeditor.com/4.11.2/standard/ckeditor.js"></script>
<script>
//문서가 로드될때 textarea를 접근하겠다
$(function(){
	init();
	
	//삭제버튼 누르면..
	//jquery는 기존의 css의 선택자를 그대로 차용
	$("#bt-del").click(function(){
		del();
	});
	$("#bt-edit").click(function(){
		edit();
	});
	$("#bt-list").click(function(){
		list();
	});
	
	
});

function init(){
	CKEDITOR.replace("content");
}

function del(){
	if(confirm("삭제하시겠습니까?")){
		//서버에 삭제 요청!!
		location.href="/board/delete?board_id=<%=board.getBoard_id()%>";
	}	
	
}

//오라클에 넣자?, 넣기를 요청하자?
//클라이언트 스크립트 언어인 자바스크립트는 원본소스가 
//사용자들의 pc로 다운받아져서 실행되므로 보안처리가 불가능하다
//따라서 서버에 요청만 할 수 있다
function regist(){
	form1.method="post"; //내용이 많기 때문에 post방식으로
	//보내야 한다...
	form1.action="/board/insert";
	form1.submit();//전송!!
}
</script>

</head>
<body onLoad="init()">
  <div class="container">
    <h1>상세보기</h1>
    <hr>
    
	<form name="form1">
	    <input type="text" value="<%=board.getWriter() %>" name="writer" required>
	    <input type="text" value="<%=board.getTitle() %>" name="title" required>
	    <textarea id="content" name="content" style="width:100%"><%=board.getContent()%></textarea>
    </form>
    <button type="button" id="bt-edit" class="registerbtn" onClick="edit()">수정</button>
    <button type="button" id="bt-del" class="registerbtn" onClick="del()">삭제</button>
    <button type="button" id="bt-list" class="registerbtn" onClick="list()">목록</button>
    
  </div>
  
  <div class="container signin">
    <p>Already have an account? <a href="#">Sign in</a>.</p>
  </div>


</body>
</html>
    