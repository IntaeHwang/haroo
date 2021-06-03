<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<title>체험학습 상세</title>
</head>
<body>
<h1>체험학습 상세보기</h1>

<button>장바구니에 넣기</button>
<button>찜하기</button>

<c:if test="${not empty learning}">
  <p><a href='/application/add'>체험학습 신청</a></p>

  <c:if test="${loginUser.no == learning.owner.no || loginUser.rank == 1}">
    <p><a href='updateForm?no=${learning.no}'>수정</a></p>
    <p><a href='delete?no=${learning.no}'>삭제</a></p>
  </c:if>

  <c:if test="${not empty learning.coverImage}">
    <c:set var="cover800x450Url">../../upload/${learning.coverImage}_800x450.jpg</c:set>
    <c:set var="coverUrl">../../upload/${learning.coverImage}</c:set>
  </c:if>
  <c:if test="${not empty learning.owner.profilePicture}">
    <c:set var="profilePictureUrl">../../upload/${learning.owner.profilePicture}_30x30.jpg</c:set>
  </c:if>
  <c:if test="${empty learning.owner.profilePicture}">
    <c:set var="profilePictureUrl">../../images/person_30x30.jpg</c:set>
  </c:if>

  <fmt:formatDate value="${learning.registeredDate}" pattern="yyyy-MM-dd hh:mm:ss" var="registeredDate"/>
  <fmt:formatDate value="${learning.schedules[0].learningDate}" pattern="yyyy-MM-dd" var="learningDate"/>
  <fmt:formatDate value="${learning.schedules[0].startTime}" pattern="HH:mm" var="startTime"/>
  <fmt:formatDate value="${learning.schedules[0].endTime}" pattern="HH:mm" var="endTime"/>

  <table border='1'>
    <tbody>
      <tr><th>가격</th> <td>${learning.price}</td></tr>
      
      <tr><th>체험날짜</th> <td>${learningDate}</td></tr>
      <tr><th>시작시간</th> <td>${startTime}</td></tr>
      <tr><th>종료시간</th> <td>${endTime}</td></tr>
         
      <tr><th>최소인원</th> <td>${learning.minPeople}</td></tr>
      <tr><th>최대인원</th> <td>${learning.maxPeople}</td></tr>
      
      <tr><th>커버이미지</th>
        <td><a href='${coverUrl}'>
        <img src='${cover800x450Url}'></a><br></td></tr>
      <tr><th>대분류</th> <td>${learning.broadCategory}</td></tr>
      <tr><th>소분류</th> <td>${learning.narrowCategory}</td></tr>
      <tr><th>제목</th> <td>${learning.name}</td></tr>
      <tr><th>광역시도</th> <td>${learning.sido}</td></tr>
      <tr><th>시군구</th> <td>${learning.sigungu}</td></tr>
      <!-- <tr><th>평균평점</th> <td>${learning.averageRate}</td></tr> -->
      <tr><th>등록일</th> <td>${registeredDate}</td></tr>
      <tr><th>본문</th> <td>${learning.intro}</td></tr>
      <tr><th>진행순서</th> <td>${learning.progressOrder}</td></tr>
      
      <tr><th>튜터사진</th> <td><a href="../tutor/detail?no=${learning.owner.no}">
      <img src="${profilePictureUrl}"></a></td></tr>
      <tr><th>튜터명</th> <td><a href="../tutor/detail?no=${learning.owner.no}">
      ${learning.owner.nickname}</a></td></tr>
      <tr><th>튜터소개</th> <td>${learning.owner.intro}</td></tr>
      
      <!-- 추후 맵 api 추가 -->
      <tr><th>환불정보</th> <td>${learning.refundInformation}</td></tr>
      <tr><th>후기</th> <td><a href='../learning/review/list?lno=${learning.no}'>후기</a></td></tr>
      <tr><th>문의</th> <td><a href='../serviceQuestion/list'>문의</a></td></tr>
    </tbody>
  </table>
</c:if>

<c:if test="${empty learning}">
  <p>해당 번호의 체험학습이 없습니다.</p>
</c:if>

</body>
</html>