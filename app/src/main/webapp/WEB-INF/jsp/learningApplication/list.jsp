<%@ page 
    language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<title>체험 신청 목록</title>
</head>
<body>
<h1>체험 신청 목록</h1>
<p><a href='form'>체험 학습 신청</a></p>
<table border='1'>
<thead>
<tr>
<th>번호</th> <th>신청자</th> <th>인원</th> <th>등록일</th>
</tr>
</thead>
<tbody> 

<c:forEach items="${learningApplication}" var="l" >
<fmt:formatDate value="${l.registeredDate}" pattern="yyyy-MM-dd" var="registeredDate"/>
  <tr> 
  <td>${l.no}</td>
  <td><a href='detail?no=${l.no}'>${l.writer.nickname}</a></td>
  <td>${l.applySize}</td>
  <td>${registeredDate}</td> 

  </tr>  
</c:forEach>

</tbody>
</table>

</body>
</html>