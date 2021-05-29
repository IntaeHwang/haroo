package com.bit189.haroo.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bit189.haroo.domain.Comment;
import com.bit189.haroo.domain.Member;
import com.bit189.haroo.service.CommentService;

@SuppressWarnings("serial")
@WebServlet("/feed/comment/update")
public class CommentUpdateHandler extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    CommentService commentService = (CommentService) request.getServletContext().getAttribute("commentService");

    try {
      int no = Integer.parseInt(request.getParameter("no"));
      String content = request.getParameter("content");
      int feedNo = Integer.parseInt(request.getParameter("feedNo"));

      Comment oldComment = commentService.get(no);

      if (oldComment == null) {
        throw new Exception("해당 번호의 댓글이 없습니다.");
      }

      Member loginUser = (Member) request.getSession().getAttribute("loginUser");
      if (loginUser.getNo() != oldComment.getWriter().getNo()) {
        throw new Exception("수정할 권한이 없습니다.");
      }

      Comment comment = new Comment();
      comment.setNo(no);
      comment.setContent(content);

      commentService.update(comment);

    } catch (Exception e) {
      throw new ServletException(e);
    }

  }

}
