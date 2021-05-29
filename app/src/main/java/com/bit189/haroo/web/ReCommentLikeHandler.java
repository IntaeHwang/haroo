package com.bit189.haroo.web;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.bit189.haroo.domain.Member;
import com.bit189.haroo.service.ReCommentService;


@Controller
public class ReCommentLikeHandler {

  ReCommentService reCommentService;

  public ReCommentLikeHandler(ReCommentService reCommentService) {
    this.reCommentService = reCommentService;
  }

  @RequestMapping("/feed/reComment/like")
  public String execute(HttpServletRequest request, HttpServletResponse response)
      throws Exception {

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


    return "";

  }

}
