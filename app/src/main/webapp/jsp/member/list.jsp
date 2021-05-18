<%@page import="com.bit189.haroo.domain.Member"%>
<%@page import="java.util.List"%>
<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<title>회원 목록</title>
</head>
<body>
<h1>회원 목록</h1>
<p><a href='add'>회원등록</a></p>
<table border='1'>
<thead>
<tr>
<th>번호</th> <th>이름</th> <th>이메일</th> <th></th> <th>전화번호</th> <th>닉네임</th> <th>성별</th>
</tr>
</thead>
<tbody>
<jsp:useBean id="list" type="List<Member>" scope="request"/>
<%
for (Member m : list) {
  pageContext.setAttribute("m", m);
  pageContext.setAttribute("profilePictureUrl",
      m.getProfilePicture() != null ? "../upload/" + m.getProfilePicture() + "_30x30.jpg" : "../images/person_30x30.jpg");
%>
<tr>
<td>${m.no}</td>
<td>${m.name}</td>
<td><a href='detail?no=${m.no}'>${m.email}</a></td>
<td><img src='${profilePictureUrl}'></td> 
<td>${m.tel}</td>
<td>${m.nickname}</td>
<td><%=m.getSex() == 1 ? "남" : "여"%></td> </tr>
<%}%>
</tbody>
</table>

<form action='list' method='get'>
<input type='search' name='keyword' value='${param.keyword}'> 
<button>검색</button>
</form>
</body>
</html>