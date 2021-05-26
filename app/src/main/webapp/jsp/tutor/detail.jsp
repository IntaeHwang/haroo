<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>튜터 상세</title>
</head>
<body>
<h1>튜터 상세보기</h1>
<c:if test="${not empty tutor}">
  <c:if test="${not empty tutor.profilePicture}">
    <c:set var="profilePicture80x80Url">../upload/${tutor.profilePicture}_80x80.jpg</c:set>
    <c:set var="profilePictureUrl">../upload/${tutor.profilePicture}</c:set>
  </c:if>
  <c:if test="${empty tutor.profilePicture}">
    <c:set var="profilePicture80x80Url">../images/person_80x80.jpg</c:set>
    <c:set var="profilePictureUrl"></c:set>
  </c:if>
		<form action='update' method='post' enctype='multipart/form-data'>
		<table border='1'>
		<tbody>
		<tr>
		  <th>번호</th>
		  <td><input type='text' name='no' value='${tutor.no}' readonly></td></tr>
		<tr>
		  <th>이름</th>
		  <td><input type='text' name='name' value='${tutor.name}' readonly></td></tr>
		<tr>
		  <th>이메일</th> 
		  <td><input type='email' name='email' value='${tutor.email}' readonly></td></tr>
		<tr>
		  <th>사진</th> 
		  <td><a href='${profilePictureUrl}'>
		  <img src='${profilePicture80x80Url}'></a><br>
		  <input name='profilepicture' type='file'></td></tr>
		<tr>
		  <th>닉네임</th> 
		  <td><input type='text' name='nickname' value='${tutor.nickname}' ></td></tr>
		<tr>
		  <th>전화번호</th> 
		  <td><input type='tel' name='tel' value='${tutor.tel}' >  <input type='button' value='문자인증'></td></tr>
		<tr>
		  <th>성별</th> 
		  <td><input type='checkbox' name='sex' ${tutor.sex == 1 ? "checked" : ""}  onclick='return(false);'>남 
		      <input type='checkbox' name='sex' ${tutor.sex == 2 ? "checked" : ""}  onclick='return(false);'>여
		<tr>
		  <th>생일</th> 
		  <td><input type='date' name='birthdate' value='${tutor.birthDate}' readonly></td></tr>
		<tr>
      <th>소개서</th> 
      <td><textarea name='intro' rows='3' cols='40'>${tutor.intro}</textarea></td></tr>
    <tr>
      <th>신청서</th> 
      <td><textarea name='application' rows='3' cols='40'>${tutor.application}</textarea></td></tr>
		<tr>
		  <th>우편번호</th> 
		  <td><input type='text' name='zipcode' value='${tutor.zipcode}' >  
		      <input type='button' value='우편번호찾기'></td></tr>
		<tr>
		  <th>기본주소</th>
		  <td><input type='text' name='address' value='${tutor.address}' >
		      <input type='button' value='주소찾기'></td></tr>
		<tr>
		  <th>상세주소</th> 
		  <td><input type='text' name='detailaddress' value='${tutor.detailAddress}' ></td></tr>
		<tr>
		  <th>가입일</th> 
		  <td>${tutor.registeredDate}</td></tr>
		<tr>
      <th>등업일</th> 
      <td>${tutor.promotedDate}</td></tr>
      <c:forEach items="${tutor.tutorCategories}" var="tc">
	    <tr>
	      <th>카테고리</th>
	      <td>${tc.broadCategory} - ${tc.narrowCategory}</td>
	    </tr>
	    </c:forEach>
		    <c:forEach items="${tutor.tutorDistricts}" var="td">
	    <tr>
		    <th>지역</th>
		    <td>${td.sido} - ${td.sigungu}</td>
	    </tr>
	    </c:forEach>
		</tbody>
		<tfoot>
		<tr>
		  <td colspan='2'>
		    <input type='submit' value='변경'> <a href='delete?no=${tutor.no}'>삭제</a> 
		</td></tr>
		</tfoot>
		</table>
		</form>
</c:if>

<c:if test="${empty tutor}">
<p>해당 번호의 튜터가 없습니다.</p>
</c:if>

<p><a href='list'>목록</a></p>
</body>
</html>
</html>
