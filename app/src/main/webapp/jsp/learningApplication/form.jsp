<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>체험 신청</title>
</head>
<body>
<h1>체험 신청</h1>
<form action='add' method='post'>

<c:forEach items="${schedules}" var="s">
  <option value='${s.no}'>${s.date}</option>
</c:forEach>

인원: <input type ='number' name='applySize'><br>
날짜: <input type ='Date' name='applySize'><br>
시작 시간: <select name='startTime'>
종료 시간: <select name='endTime'>
</select><br>
</form>
</body>
</html>