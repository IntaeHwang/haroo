package com.bit189.haroo.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bit189.haroo.domain.Member;
import com.bit189.haroo.service.FeedService;

@SuppressWarnings("serial")
@WebServlet("/feed/like")
public class FeedLikeHandler extends HttpServlet{

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    FeedService feedService = (FeedService) request.getServletContext().getAttribute("feedService");


    try {
      response.setContentType("text/plain;charset=UTF-8");
      PrintWriter out = response.getWriter();

      Member loginUser = (Member) request.getSession().getAttribute("loginUser");
      if (loginUser == null) {
        out.print("login");
      }

      int feedNo = Integer.parseInt(request.getParameter("no"));

      int isLike = feedService.getLike(feedNo, loginUser.getNo());

      if (isLike == 1) {
        feedService.deleteLike(feedNo, loginUser.getNo());
        out.print("no");
      } else {
        feedService.addLike(feedNo, loginUser.getNo());
        out.print("yes");
      }

      //      response.sendRedirect("list");

    } catch (Exception e) {
      throw new ServletException(e);
    }


  }

}
