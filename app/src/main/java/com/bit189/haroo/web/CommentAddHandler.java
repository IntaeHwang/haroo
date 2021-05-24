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
@WebServlet("/feed/comment/add")
public class CommentAddHandler extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    CommentService commentService = (CommentService) request.getServletContext().getAttribute("commentService");

    try {
      Comment comment = new Comment();
      comment.setFeedNo(Integer.parseInt(request.getParameter("no")));
      comment.setContent(request.getParameter("content"));

      Member loginUser = (Member) request.getSession().getAttribute("loginUser");
      comment.setWriter(loginUser);

      commentService.add(comment);

      response.sendRedirect("../detail?no=" + comment.getFeedNo());

    } catch (Exception e) {

    }

  }

}