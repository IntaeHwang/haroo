package com.bit189.haroo.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bit189.haroo.domain.Member;
import com.bit189.haroo.domain.ReComment;
import com.bit189.haroo.service.ReCommentService;

@SuppressWarnings("serial")
@WebServlet("/feed/reComment/update")
public class ReCommentUpdateHandler extends HttpServlet {
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    ReCommentService reCommentService = (ReCommentService) request.getServletContext().getAttribute("reCommentService");

    try {
      int no = Integer.parseInt(request.getParameter("no"));
      String content = request.getParameter("content");
      int feedNo = Integer.parseInt(request.getParameter("feedNo"));

      ReComment oldReComment = reCommentService.get(no);

      if (oldReComment == null) {
        throw new Exception("해당 번호의 대댓글이 없습니다.");
      }

      Member loginUser = (Member) request.getSession().getAttribute("loginUser");
      if (loginUser.getNo() != oldReComment.getReWriter().getNo()) {
        throw new Exception("수정할 권한이 없습니다.");
      }

      ReComment reComment = new ReComment();
      reComment.setNo(no);
      reComment.setContent(content);

      reCommentService.update(reComment);

      //      response.sendRedirect("../detail?no=" + feedNo);
    } catch (Exception e) {
      throw new ServletException(e);
    }
  }



}
