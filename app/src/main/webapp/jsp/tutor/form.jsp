<%@page import="com.bit189.haroo.domain.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>튜터 등록</title>
</head>
<body>
<h1>튜터 등록</h1>
<form action="add" method="post" enctype="multipart/form-data">
튜터소개:   <br><textarea name='intro' rows='5' cols='40'></textarea><br>
튜터신청서: <br><textarea name='application' rows='5' cols='40'></textarea><br>
<input type="submit" value="등록">
</form>
</body>
</html>