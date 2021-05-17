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
<p><a href='form.html'>회원등록</a></p>
<table border='1'>
<thead>
<tr>
<th>번호</th> <th>이름</th> <th>이메일</th> <th>사진</th> <th>전화번호</th> <th>닉네임</th> <th>성별</th>
</tr>
</thead>
<tbody>
<jsp:useBean id="list" type="List<Member>" scope="request"/>
<%
for (Member m : list) {
%>
<tr>
<td><%=m.getNo()%></td>
<td><%=m.getName()%></td>
<td><a href='detail?no=<%=m.getNo()%>'><%=m.getEmail()%></a></td>
<td><img src='<%=m.getProfilePicture() != null ? 
      "../upload/" + m.getProfilePicture() + "_30x30.jpg" : "../images/person_30x30.jpg"%>'></td> 
<td><%=m.getTel()%></td>
<td><%=m.getNickname()%></td>
<td><%=m.getSex() == 1 ? "남" : "여"%></td> </tr>
<%}%>
</tbody>
</table>

<% String keyword = request.getParameter("keyword");%>
<form action='list' method='get'>
<input type='search' name='keyword' value='<%=keyword != null ? keyword : ""%>'> 
<button>검색</button>
</form>
</body>
</html>