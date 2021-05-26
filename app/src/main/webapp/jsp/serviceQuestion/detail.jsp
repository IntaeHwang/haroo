<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:formatDate value="${question.writingDate}" pattern="yyyy-MM-dd HH:mm:ss" var="writingDate"/>
<!DOCTYPE html>
<html>
<head>
<title>문의글 상세</title>
</head>
<body>
<h1>문의글 상세보기</h1>

<c:if test="${not empty question}">
<form action='update' method='post'>
<table border='1'>
	<tbody>
		<tr><th>번호</th> <td><input type='text' name='no' value='${question.no}' readonly></td></tr>
		<tr><th>제목</th> <td><input name='title' type='text' value='${question.title}'></td></tr>
		<tr><th>내용</th> <td><textarea name='content' rows='10' cols='60'>${question.content}</textarea></td></tr>
		<tr><th>첨부파일</th> <td>
          <c:forEach items="${question.attachedFiles}" var="file">
            <c:if test="${not empty file.name}">
             <c:set var="photoUrl">../upload/${file.name}_500x500.jpg</c:set>
            </c:if>     
            <img src='${photoUrl}'>
          </c:forEach>
        </td>
      </tr>
		<tr><th>작성자</th> <td>${question.writer.name}</td></tr>
		<tr><th>등록일</th> <td>${question.writingDate}</td></tr>
		<tr><th>조회수</th> <td>${question.viewCount}</td></tr>
	</tbody>

  <c:if test="${not empty loginUser and loginUser.no == question.writer.no}">
	<tfoot>
	<tr>
	  <td colspan='2'>
	    <p><a href='update?no=${question.no}'>수정</a></p>
    <p><a href='delete?no=${question.no}'>삭제</a></p>
	  </td>
	</tr>
	</tfoot>    
  </c:if>
  
</table>
<p><a href='list'>목록</a></p>
</form>
</c:if>

<c:if test="${empty question}">
<p>해당 번호의 문의글이 없습니다.</p>
</c:if>


</body>
</html>