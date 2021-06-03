<%@ page language="java" 
  contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"
  trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>사용자 정보</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
<link href="../css/common.css" rel="stylesheet" >
</head>
<body>
<div class="container">
<h1>사용자 정보</h1>
<c:if test="${empty loginUser}">
  <p>로그인 하지 않았습니다.</p>
</c:if>

<c:if test="${not empty loginUser}">
  <c:if test="${not empty loginUser.profilePicture}">
  <c:set var="profilePicture110x110Url">../upload/${loginUser.profilePicture}_110x110.jpg</c:set>
  <c:set var="profilePictureUrl">../upload/${loginUser.profilePicture}</c:set>
  </c:if>
  <c:if test="${empty loginUser.profilePicture}">
    <c:set var="profilePicture80x80Url">../images/person_80x80.jpg</c:set>
    <c:set var="profilePictureUrl"></c:set>
</c:if>
	<table border='1'>
	<tbody>
	<tr>
	  <th>사용자 번호</th> 
	  <td>${loginUser.no}</td></tr>
	<tr>
	  <th>이름</th> 
	  <td>${loginUser.name}</td></tr>
	<tr>
	  <th>이메일</th> 
	  <td>${loginUser.email}</td></tr>
	<tr>
	  <th>사진</th> 
	  <td><a href='${profilePictureUrl}'>
	  <img src='${profilePicture110x110Url}'></a></td></tr>
	</tbody>
	</table>
</c:if>
</div>
</body>
</html>
