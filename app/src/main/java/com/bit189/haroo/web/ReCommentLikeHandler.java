package com.bit189.haroo.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bit189.haroo.domain.Member;
import com.bit189.haroo.service.ReCommentService;

@SuppressWarnings("serial")
@WebServlet("/feed/reComment/like")
public class ReCommentLikeHandler extends HttpServlet{

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    ReCommentService reCommentService = (ReCommentService) request.getServletContext().getAttribute("reCommentService");


    try {
      response.setContentType("text/plain;charset=UTF-8");
      PrintWriter out = response.getWriter();

      Member loginUser = (Member) request.getSession().getAttribute("loginUser");
      if (loginUser == null) {
        out.print("login");
      }

      int reCommentNo = Integer.parseInt(request.getParameter("no"));

      int isLike = reCommentService.getLike(reCommentNo, loginUser.getNo());

      if (isLike == 1) {
        reCommentService.deleteLike(reCommentNo, loginUser.getNo());
        out.print("no");
      } else {
        reCommentService.addLike(reCommentNo, loginUser.getNo());
        out.print("yes");
      }


    } catch (Exception e) {
      throw new ServletException(e);
    }


  }

}
