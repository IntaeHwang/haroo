<%@ page language="java" 
  contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"
  trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<title>로그인</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
<link href="../css/common.css" rel="stylesheet" >
</head>
<body>
<div class="container">
<h1>로그인</h1>
<form action="login" method='post'>
<table border='1'>
<tbody>
<div class="mb-3 row">
    <label for="email" class="col-sm-1 col-form-label">이메일</label>
    <div class="col-sm-7">
      <input type="email" class="form-control form-control-sm" id="email" name="email" value='${cookie.email.value}'>
    </div>
  </div>
  <div class="mb-3 row">
    <label for="password" class="col-sm-1 col-form-label">암호</label>
    <div class="col-sm-7">
      <input type="password" class="form-control form-control-sm" id="password" name="password" >
    </div>
  </div>
</tbody>
<tfoot>
<div class="mb-3 row">
    <label for="saveEmail" class="col-sm-1 col-form-label">이메일 저장</label>
    <div class="col-sm-7">
      <input type="checkbox"  id="saveEmail" name="saveEmail" >
    </div>
  </div>
  <button class="btn btn-primary btn-sm">로그인</button>
  <a href='member/form' class="btn btn-primary btn-sm">회원가입</a>
</tfoot>
</table>
</form>
</body>
</html>
