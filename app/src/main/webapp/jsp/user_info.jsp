
<%@page import="com.bit189.haroo.domain.Member"%>
<%@ page language="java" 
  contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"
  trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<title>사용자 정보</title>
</head>
<body>
<h1>사용자 정보</h1>
<jsp:useBean id="loginUser" type="com.bit189.haroo.domain.Member" scope="session"></jsp:useBean>
<%
if (loginUser == null) {
%>
  <p>로그인 하지 않았습니다.</p>
<%
} else {
%>
<table border='1'>
<tbody>
<tr>
  <th>사용자 번호</th> 
  <td><%=loginUser.getNo()%></td></tr>
<tr>
  <th>이름</th> 
  <td><%=loginUser.getName()%></td></tr>
<tr>
  <th>이메일</th> 
  <td><%=loginUser.getEmail()%></td></tr>
<tr>
  <th>사진</th> 
  <td><a href='<%=loginUser.getProfilePicture() != null ? "upload/" + loginUser.getProfilePicture() : ""%>'>
  <img src='<%=loginUser.getProfilePicture() != null ? 
      "upload/" + loginUser.getProfilePicture() + "_80x80.jpg" : "images/person_80x80.jpg"%>'></a></td></tr>
</tbody>
</table>
<%
}
%>
</body>
</html>
