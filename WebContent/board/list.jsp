<%@page import="com.itbank.model.domain.Board"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<Board> boardList=(List)request.getAttribute("boardList");
	out.print("게시물의 갯수는 "+boardList.size());
	
	int currentPage=1;
	currentPage=(int)request.getAttribute("currentPage");
	int totalRecord=boardList.size(); //총 레코드 수
	int pageSize=10; //페이당 보여질 레코드 수
	int totalPage=(int)Math.ceil((float)totalRecord/pageSize); //3.0
	int blockSize=10;//블럭당 보여질 페이지 수
	int firstPage=currentPage-(currentPage-1)%blockSize;
	int lastPage=firstPage+(blockSize-1);
	int curPos=(currentPage-1)*pageSize; //페이지당 꺼낼 리스트의 시작 인덱스!!!
	int num=totalRecord-curPos; //페이지당 시작 번호
	out.print("현재 페이지는 "+currentPage);
%>    
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
table {
  border-collapse: collapse;
  border-spacing: 0;
  width: 100%;
  border: 1px solid #ddd;
}

th, td {
  text-align: left;
  padding: 16px;
}

tr:nth-child(even) {
  background-color: #f2f2f2
}
</style>
<script>
/*자바스크립트 언어란?
1)jsp는 서버에서만 실행되고, javascript는 클라이언트에서만 수행됨..
2)자바스크립트 사용이유는?
    html은 프로그램 능력이 없는 그냥 문서이기 때문에 html의 
    프로그래밍적 기능을 보완하기 위해 사용됨..		
*/
function registForm(){
	location.href="/board/write.jsp";
}
</script>
</head>
<body>
<h2>Zebra Striped Table</h2>
<p>For zebra-striped tables, use the nth-child() selector and add a background-color to all even (or odd) table rows:</p>

<table>
  <tr>
    <th>번호</th>
    <th>제목</th>
    <th>작성자</th>
    <th>작성일</th>
    <th>조회수</th>
  </tr>
  <%for(int i=0;i<pageSize;i++){%>
  <%if(num<1)break; %>
  <%Board board=boardList.get(curPos++); %>
  <tr>
    <td><%=num-- %></td>
    <td>
    	<a href="/board/content?board_id=<%=board.getBoard_id()%>"><%=board.getTitle() %></a>
    </td>
    <td><%=board.getWriter() %></td>
    <td><%=board.getRegdate().substring(0,10) %></td>
    <td><%=board.getHit() %></td>
  </tr>
  <%} %>
  <tr>
  	<td colspan="5">
  		<button onClick="registForm()">글등록</button>
  	</td>
  </tr>
  <tr>
  	<td colspan="5">
  		<%if(firstPage-1 >1){ %>
  			<a href="/board/list?currentPage=<%=firstPage-1%>">◀</a>
  		<%}else{ %>
  			<a href="javascript:alert('처음 페이지 입니다')">◀</a>
  		<%} %>
  		
  		<%for(int i=firstPage;i<=lastPage;i++){ %>
  		<%if(i>totalPage)break; %>
  		<a href="/board/list?currentPage=<%=i%>">[ <%=i%> ]</a>
  		<%}%>
		
		<%if(lastPage+1 < totalPage){%>
  			<a href="/board/list?currentPage=<%=lastPage+1%>">▶</a>
  		<%}else{ %>
  			<a href="javascript:alert('마지막 페이지입니다');">▶</a>
		<%}%>
  	</td>
  </tr>

</table>

</body>
</html>
    
    
    
    
    
    