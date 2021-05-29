package com.bit189.haroo.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.bit189.haroo.domain.Feed;
import com.bit189.haroo.domain.Member;
import com.bit189.haroo.service.FeedService;
import com.bit189.haroo.service.PostService;


@Controller
public class FeedDeleteHandler {

  @RequestMapping("/feed/delete")
  public String execute(HttpServletRequest request, HttpServletResponse response)
      throws Exception {
    FeedService feedService = (FeedService) request.getServletContext().getAttribute("feedService");
    PostService postService = (PostService) request.getServletContext().getAttribute("postService");

    int no = Integer.parseInt(request.getParameter("no"));

    Feed feed = feedService.get(no);

    Member loginUser = (Member) request.getSession().getAttribute("loginUser");
    if (feed.getWriter().getNo() != loginUser.getNo()) {
      throw new Exception("삭제 권한이 없습니다!");
    }

    postService.delete(no);

    return "redirect:list";

  }

}
