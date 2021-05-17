<%@page import="com.bit189.haroo.domain.Member"%>
<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<title>회원 상세</title>
</head>
<body>
<h1>회원 상세보기</h1>
<jsp:useBean id="member" type="com.bit189.haroo.domain.Member" scope="request"/>
<%
if (member != null) {
%>
<form action='update' method='post' enctype='multipart/form-data'>
<table border='1'>
<tbody>
<tr>
  <th>번호</th>
  <td><input type='text' name='no' value='${member.no}' readonly></td></tr>
<tr>
  <th>이름</th>
  <td><input type='text' name='name' value='${member.name}' readonly></td></tr>
<tr>
  <th>이메일</th> 
  <td><input type='email' name='email' value='${member.email}' readonly></td></tr>
<tr>
  <th>닉네임</th> 
  <td><input type='text' name='nickname' value='${member.nickname}' ></td></tr>
<tr>
  <th>사진</th> 
  <td><a href='<%=member.getProfilePicture() != null ? " ../upload/" + member.getProfilePicture() : ""%>'>
  <img src='<%=member.getProfilePicture() != null ?
      "../upload/" + member.getProfilePicture() + "_80x80.jpg" : " ../images/person_80x80.jpg"%>'></a><br>
      <input name='profilepicture' type='file'></td></tr>
<tr>
  <th>전화번호</th> 
  <td><input type='tel' name='tel' value='${member.tel}' >  <input type='button' value='문자인증'></td></tr>
<tr>
  <th>성별</th> 
  <td><input type='radio' name='sex' value='<%=member.getSex() == 1 ? "checked" : ""%>'  onclick='return(false);'>남 
      <input type='radio' name='sex' value='<%=member.getSex() == 2 ? "checked" : ""%>'  onclick='return(false);'>여
<tr>
  <th>생일</th> 
  <td><input type='date' name='birthdate' value='${member.birthDate}' readonly></td></tr>
<tr>
  <th>우편번호</th> 
  <td><input type='text' name='zipcode' value='${member.zipcode}' >  
      <input type='button' value='우편번호찾기'></td></tr>
<tr>
  <th>기본주소</th>
  <td><input type='text' name='address' value='${member.address}' >
      <input type='button' value='주소찾기'></td></tr>
<tr>
  <th>상세주소</th> 
  <td><input type='text' name='detailaddress' value='${member.detailAddress}' ></td></tr>
<!--  <tr>
  <th>회원등급</th> 
  <td><%=member.getRank() == 1 ? "회원" : member.getRank() == 2 ? "튜터" : "관리자"%> </td></tr>-->
<tr>
  <th>가입일</th> 
  <td>${member.registeredDate}</td></tr>
</tbody>
<tfoot>
<tr>
  <td colspan='2'>
    <input type='submit' value='변경'> <a href='delete?no=${member.no}'>삭제</a> 
</td></tr>
</tfoot>
</table>
</form>

<%} else {%>
<p>해당 번호의 회원이 없습니다.</p>
<%}%>

<p><a href='list'>목록</a></p>
</body>
</html>
</html>
