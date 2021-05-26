package com.bit189.haroo.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bit189.haroo.service.ReCommentService;

@SuppressWarnings("serial")
@WebServlet("/feed/reComment/update")
public class ReCommentUpdateHandler extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    ReCommentService reCommentService = (ReCommentService) request.getServletContext().getAttribute("reCommentService");

    try {
      int no = Integer.parseInt(request.getParameter("no"));
      int feedNo = Integer.parseInt(request.getParameter("feedNo"));

      System.out.println("수정하는 코드를 작성해보자!");

      //      Comment comment = commentService.get(no);
      //
      //      Member loginUser = (Member) request.getSession().getAttribute("loginUser");
      //      if (loginUser.getNo() != comment.getWriter().getNo()) {
      //        throw new Exception("수정할 권한이 없습니다.");
      //      }
      //
      //      HttpSession session = request.getSession();
      //      request.setAttribute("commentContent", comment.getContent());
      //
      //
      //      response.setContentType("text/html;charset=UTF-8");
      //      request.getRequestDispatcher("../detail?no=" + comment.getFeedNo()).include(request, response);
      //
      //      System.out.println("다시와?");
      response.sendRedirect("../detail?no=" + feedNo);
    } catch (Exception e) {
      throw new ServletException(e);
    }
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    //    CommentService commentService = (CommentService) request.getServletContext().getAttribute("commentService");
    //
    try {
      System.out.println("수정코드를 짜자!");
      //      Comment comment = new Comment();
      //      comment.setFeedNo(Integer.parseInt(request.getParameter("no")));
      //      comment.setContent(request.getParameter("content"));
      //
      //      Member loginUser = (Member) request.getSession().getAttribute("loginUser");
      //      comment.setWriter(loginUser);
      //
      //      commentService.add(comment);
      //
      //      response.sendRedirect("../detail?no=" + comment.getFeedNo());

    } catch (Exception e) {
      throw new ServletException(e);
    }

  }

}
