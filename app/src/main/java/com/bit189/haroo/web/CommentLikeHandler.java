package com.bit189.haroo.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bit189.haroo.domain.Member;
import com.bit189.haroo.service.CommentService;

@SuppressWarnings("serial")
@WebServlet("/feed/comment/like")
public class CommentLikeHandler extends HttpServlet{

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    CommentService commentService = (CommentService) request.getServletContext().getAttribute("commentService");


    try {
      response.setContentType("text/plain;charset=UTF-8");
      PrintWriter out = response.getWriter();

      Member loginUser = (Member) request.getSession().getAttribute("loginUser");
      if (loginUser == null) {
        out.print("login");
      }

      int commentNo = Integer.parseInt(request.getParameter("no"));

      int isLike = commentService.getLike(commentNo, loginUser.getNo());

      if (isLike == 1) {
        commentService.deleteLike(commentNo, loginUser.getNo());
        out.print("no");
      } else {
        commentService.addLike(commentNo, loginUser.getNo());
        out.print("yes");
      }

      //      response.sendRedirect("list");

    } catch (Exception e) {
      throw new ServletException(e);
    }


  }

}
