package com.bit189.haroo.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.bit189.haroo.domain.Member;
import com.bit189.haroo.domain.ReComment;
import com.bit189.haroo.service.ReCommentService;


@Controller
@RequestMapping("/feed/reComment")
public class ReCommentController {

  ReCommentService reCommentService;

  public ReCommentController(ReCommentService reCommentService) {
    this.reCommentService = reCommentService;
  }

  @PostMapping("add")
  public String add(ReComment reComment, int feedNo, HttpSession session) throws Exception {

    Member loginUser = (Member) session.getAttribute("loginUser");

    reComment.setReWriter(loginUser);

    reCommentService.add(reComment);

    return "redirect:../detail?no=" + feedNo;


  }


  @RequestMapping("delete")
  public String delete(HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    int no = Integer.parseInt(request.getParameter("no"));

    ReComment reComment = reCommentService.get(no);

    Member loginUser = (Member) request.getSession().getAttribute("loginUser");
    if (loginUser.getNo() != reComment.getReWriter().getNo()) {
      throw new Exception("삭제 권한이 없습니다!");
    }

    reCommentService.delete(no);

    return "redirect:../detail?no=" + Integer.parseInt(request.getParameter("feedNo"));

  }

}
