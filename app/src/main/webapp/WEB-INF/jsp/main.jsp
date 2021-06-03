<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>메인</title>
</head>
<body>
   <c:if test="${empty loginUser}">
      <h1>비회원</h1>
      <p>
         <a href='member/form'>회원가입</a>
      </p>
      <p>
         <a href='login_form'>로그인</a>
      </p>
      <p>
         <a href='learning/list'>클래스 찾기</a>
      </p>
      <p>
         <a href='feed/list'>피드 목록</a>
      </p>
   </c:if>
   <c:if test="${not empty loginUser and loginuser.id}">
   <!--  Member loginUser = (Member) session.getAttribute("loginUser");
    member.setNo(loginUser.getNo());-->
    
      <h1>회원</h1>
      <p>
      <form action='member/detail' method='get'>
         </p>
         <input name='detail' type='submit' value='내 정보 관리'>
      </form>
      <p>
      <form action='logout' method='post'>
         </p>
         <input name='logout' type='submit' value='로그아웃'>
      </form>
      <p>
         <a href='tutor/list'>튜터 찾기</a>
      </p>
      <p>
         <a href='learning/list'>클래스 찾기</a>
      </p>
      <p>
         <a href='feed/list'>피드 목록</a>
      </p>
   </c:if>
</body>
</html>