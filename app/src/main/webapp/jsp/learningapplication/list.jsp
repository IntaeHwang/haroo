<%@page import="java.util.List"%>
<%@ page 
    language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="ture"%>
    
    
<!DOCTYPE html>
<html>
<head>
<title>체험 신청 목록</title>
</head>
<body>
<h1>체험 신청 목록</h1>
<table border='1'>
<thead>
<tr>
<th>번호</th> <th>날짜</th> <th>시작 시간</th> <th>종료 시간</th> <th>인원</th> <th>회차</th>
</tr>
</thead>
<tbody> 
<% 
List<LearningApplication> list = (List<LearningApplication>) request.getAttribute("list");
for (LearningApplication l : list) {
  %>
  <tr> 
  <td><%=b.getNo()%></td>
  <td>< href='detail?no=<%=b.getNo()%>'></td> 
  <td><%=b.getWriter().getName()%></td> 
  <td><%=b.getRegisteredDate()%></td> 
  <td><%=b.getViewCount()%></td>
  </tr>  
<% 
}
%>
</tbody>
</table>
<form action='search' method='get'>
<input type='text' name='keyword'> 
<button>검색</button>
</form>
</body>
</html>
</body>
</html>