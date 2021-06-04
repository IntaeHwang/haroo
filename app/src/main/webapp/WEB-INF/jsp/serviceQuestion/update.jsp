<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>

</head>
<body>
<c:if test="${not empty question}">
<meta charset="UTF-8">
<div class="container col-md-6">

   <form action="update" method="post" enctype="multipart/form-data">
    <input type="hidden" name="no" value="${question.no}"/>
        <div class="form-group">
            <label for="exampleFormControlInput1">제목</label>
            <input type="text" class="form-control" id="exampleFormControlInput1" name="title" value="${question.title}" readonly>
        </div>
        <div class="form-group">
            <label for="exampleFormControlInput1">작성자</label>
            <input type="text" class="form-control" id="exampleFormControlInput1" value="${question.writer.name}" readonly>
        </div>
        <div class="form-group">
            <label for="exampleFormControlTextarea1">내용</label>
            <textarea class="form-control" id="exampleFormControlTextarea1" rows="10" name="content">${question.content}</textarea>
        </div>

        <button type="submit" class="btn btn-info">수정하기</button>
        <button type="button" class="btn btn-secondary">뒤로가기</button>
        
    </form>
</div>
</c:if>


</body>
</html>