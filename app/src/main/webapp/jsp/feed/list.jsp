<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<title>스토리 목록</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>

<style>
body {
	line-height: 1;
}

.card {
	width: 330px;
	height: 330px;
	display: inline-block;
	margin : 0 30px 30px 0px;
}

.card img {
	height: 219px;
	border-radius: 0;
	border: 0;
}

.har-feed-info {
	padding: 14px 10px;
}

.har-feed-pro {
	width: 35px;
	height: 35px;
	overflow: hidden;
	border-radius: 20px;
	float: left;
	margin-right: 10px;
}

.har-feed-pro img {
	height: 35px;
}

.har-feed-font {
	font-size: 14px;
	display: inline;
}

.har-feed-font2 {
	font-size: 12px;
	margin: 3px 0 0 0px;
	color: #999;
}

.card-body {
	padding: 10px;
}

.like {
	display: inline-block;
	height: 20px;
	width: 23px;
	background-image: url('../../images/icon.png');
	background-repeat: no-repeat;
	background-position: -9px -9px;
	background-size: 560px;
	box-sizing: border-box;
	position: relative;
	top: 6px;
}

.comment {
	display: inline-block;
	height: 20px;
	width: 23px;
	background-image: url('../../images/icon.png');
	background-repeat: no-repeat;
	background-position: -67px -9px;
	background-size: 560px;
	box-sizing: border-box;
	position: relative;
	top: 6px;
}

.har-feed-font3 {
	font-size: 13px;
	display: inline-block;
	margin-right: 15px;
	color: #7F7F7F;
	position: relative;
	top: 1px;
}
</style>

</head>
<body>
	<h1>스토리 목록(JSTL)</h1>
	
	<p><a href='add'>스토리 등록</a></p>

	<c:forEach items="${feeds}" var="feed">
	<fmt:formatDate value="${feed.writingDate}" pattern="yyyy년 MM월 dd일" var="writingDate"/>
		<c:if test="${not empty feed.attachedFiles.get(0)}">
			<c:set var="photoUrl">../../upload/${feed.attachedFiles.get(0).name}_330x220.jpg</c:set>
		</c:if>
		
		<div class="card">
			<div class="har-feed-info">
				<div class="har-feed-pro">
					<img src="${feed.writer.profilePicture}">
					<!-- <img src="/Users/kimseongeun/Desktop/test.png"> -->
				</div>

				<p class="fw-bold har-feed-font">${feed.writer.name}</p>
				<p class="fw-light har-feed-font2">${writingDate}</p>
			</div>
			<a href='detail?no=${feed.no}'><img src='${photoUrl}' class="card-img-top"></a>
			<div class="card-body">
				<div class="like"></div>
				<p class="fst-normal har-feed-font3">${feed.likeCount}</p>
				<div class="comment"></div>
				<p class="fst-normal har-feed-font3">${feed.commentCount}</p>
			</div>
		</div>
	</c:forEach>

	<%-- <table border='1'>
		<thead>
			<tr>
			<th>프로필사진</th>
			<th>이름</th>
			<th>등록일자</th>
			<th>사진</th>
			<th>좋아요수</th>
			<th>댓글수</th>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach items="${feeds}" var="feed">
				<c:if test="${not empty feed.attachedFiles.get(0)}">
	       <c:set var="photoUrl">../../upload/${feed.attachedFiles.get(0).name}_330x220.jpg</c:set>
	      </c:if>
			<tr>
			 <td>${feed.writer.profilePicture}</td>
			 <td>${feed.writer.name}</td>
			 <td>${feed.writingDate}</td> 
			 <td><a href='detail?no=${feed.no}'><img src='${photoUrl}'></a></td> 
			 <td>${feed.likeCount}</td>
			 <td>${feed.commentCount}</td></tr>
			</c:forEach>
		</tbody>
	</table> --%>
</body>
</html>
