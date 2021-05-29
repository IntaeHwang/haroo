package com.bit189.haroo.web;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.bit189.haroo.domain.Member;
import com.bit189.haroo.service.FeedService;


@Controller
public class FeedLikeHandler {

  FeedService feedService;

  public FeedLikeHandler(FeedService feedService) {
    this.feedService = feedService;
  }

  @RequestMapping("/feed/like")
  public String execute(HttpServletRequest request, HttpServletResponse response)
      throws Exception {

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

    return "redirect:list";



  }

}
