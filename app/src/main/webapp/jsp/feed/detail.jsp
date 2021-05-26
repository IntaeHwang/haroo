<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<title>피드 상세</title>
<style type="text/css">
  .profile-photo {
    width : 35px;
    height : 35px;
    border-radius: 10px;
  }
  
</style>
</head>
<body>
	<h1>피드 상세보기js</h1>
	
	<c:if test="${not empty feed}">
		<form action='update' method='post'>
			<table border='1'>
			<tbody>
			<tr><th>번호</th> <td><input type='text' name='no' value='${feed.no}' readonly></td></tr>
			<tr><th>프로필사진</th> <td><div class="profile-photo">${feed.writer.profilePicture}</div></td></tr>
			<tr><th>튜터이름</th> <td>${feed.writer.name}</td></tr>
			<tr><th>등록일</th> <td>${feed.writingDate}</td></tr>
			
				<th>사진</th>
				<td>
					<c:forEach items="${feed.attachedFiles}" var="file">
						<c:if test="${not empty file.name}">
	           <c:set var="photoUrl">../upload/${file.name}_500x500.jpg</c:set>
	          </c:if>
	          
					  <img src='${photoUrl}'>
					</c:forEach>
				</td>
			</tr>
			<tr><th>내용</th> <td><textarea name='content' rows='10' cols='60'>${feed.content}</textarea></td></tr>
			<tr><th>조회수</th> <td>${feed.viewCount}</td></tr>
			<tr><th>좋아요수</th> <td>${feed.likeCount}</td></tr>
			<tr><th>댓글수</th> <td>${feed.commentCount}</td></tr>
			</tbody>
			</table>
			
			<c:if test="${not empty loginUser and loginUser.no == feed.writer.no}">
			<input type="submit" value="수정">
			
			 <a href="delete?no=${feed.no}">삭제</a>
			</c:if>
		</form>
	
	
		<c:forEach items="${comments}" var="comment">
				<pre><b>${comment.writer.name}</b> ${comment.content}</pre>
				<button type="button" onclick="reCommentAdd(${comment.no},${comment.writer.no},${feed.no})">답글달기</button>
	     	
	     	<c:if test="${not empty loginUser and loginUser.no == comment.writer.no}">
	     	  <a href="comment/delete?no=${comment.no}&feedNo=${feed.no}">댓글삭제</a>
	     	</c:if>
     	
		  <c:forEach items="${comment.reComments}" var="reComment">
			  <c:if test="${reComment.state == true}">
					<pre>     <b>${reComment.reWriter.name}</b> @${reComment.taggedMember.name} ${reComment.content}</pre>
	        <button type="button" onclick="reCommentAdd(${comment.no},${reComment.reWriter.no},${feed.no})">답글달기</button>
	        
	        <c:if test="${not empty loginUser and loginUser.no == reComment.reWriter.no}">
	          <button type="button" onclick="reCommetnUpdate()">수정</button>
	          <a href="reComment/delete?no=${reComment.no}&feedNo=${feed.no}">대댓글삭제</a>
	        </c:if>
				</c:if>
		  </c:forEach>
		</c:forEach>
		
		<form action='comment/add' method='post' id="har-comment-add">
			<input type="hidden" name="no" value="${feed.no}" />
			<input type="text" name="content" placeholder="댓글을 달아주세요."/>
			<input type='submit' value='등록'>
		</form>
		
	</c:if>
	
	<c:if test="${empty feed}">
   <p>없는 피드입니다.</p>
  </c:if>
	
	<p><a href='list'>목록</a></p>
	
	<script>
	function reCommentAdd(cmtNo, tgNo, fdNo) {
		var cmtForm = document.getElementById("har-comment-add");
		var originForm = cmtForm.innerHTML;
		
		cmtForm["action"] = "reComment/add";
		
		cmtForm.innerHTML = "<input type='hidden' name='commentNo' value='" + cmtNo + "'/>" 
			   + "<input type='hidden' name='taggedNo' value='" + tgNo + "'/>"
			   + "<input type='hidden' name='no' value='" + fdNo + "' />"
			   + "<input type='text' name='content' placeholder='댓글을 달아주세요.'/>"
			   + "<input type='submit' value='등록'>";
	}
	
	
	 function reCommetnUpdate() {
		 colsole.log("대댓글 수정 코드를 달아봅시다!");
	 }
	</script>
</body>
</html>
