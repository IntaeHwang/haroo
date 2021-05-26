<%@ page 
    language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:formatDate value="${question.writingDate}" pattern="yyyy-MM-dd" var="writingDate"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의 목록</title>
</head>
<body>
<h1>문의 목록</h1>
<p><a href='add'>새 글</a></p>
<table border='1'>
<thead>
<tr>
<th>번호</th>
<th>제목</th>
<th>작성자</th>
<th>등록일</th>
<th>조회수</th>
</tr>
</thead>
<tbody>
<c:forEach items="${questions}" var="question">
<tr> 
        <c:if test="${question.secret eq 'N'}" >
            <c:choose>
                <c:when test="${loginUser eq loginUser.no}">
                    <c:out value="${question.title}"/>
                </c:when>
                <c:otherwise>비밀글은 작성자와 튜터만 볼 수 있습니다.</c:otherwise>
            </c:choose>
        </c:if>
        <c:if test="${question.secret eq 'Y'}" >
            <c:out value="${question.title}"/>
        </c:if>
      <td>${question.no}</td>
  <td><a href='detail?no=${question.no}'>${question.title}</a></td>
  <td>${question.writer.nickname}</td>
  <td>${question.writingDate}</td>
  <td>${question.viewCount}</td>        
    </tr>
</c:forEach>

</tbody>
</table>

<form action='list' method='get'>
<input type='search' name='keyword' value='${param.keyword}'>
<button>검색</button>
</form>
</body>
</html>