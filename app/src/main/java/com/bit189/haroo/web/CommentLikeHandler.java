package com.bit189.haroo.web;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.bit189.haroo.domain.Member;
import com.bit189.haroo.service.CommentService;


@Controller
public class CommentLikeHandler {

  CommentService commentService;

  public CommentLikeHandler(CommentService commentService) {
    this.commentService = commentService;
  }

  @RequestMapping("/feed/comment/like")
  public String execute(HttpServletRequest request, HttpServletResponse response)
      throws Exception {

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

    return "redirect:list";



  }

}
