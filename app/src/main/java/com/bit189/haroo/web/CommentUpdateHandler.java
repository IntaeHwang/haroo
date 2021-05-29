package com.bit189.haroo.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.bit189.haroo.domain.Comment;
import com.bit189.haroo.domain.Member;
import com.bit189.haroo.service.CommentService;


@Controller
public class CommentUpdateHandler {

  CommentService commentService;

  public CommentUpdateHandler(CommentService commentService) {
    this.commentService = commentService;
  }

  @RequestMapping("/feed/comment/update")
  public String execute(HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    int no = Integer.parseInt(request.getParameter("no"));
    String content = request.getParameter("content");
    int feedNo = Integer.parseInt(request.getParameter("feedNo"));

    Comment oldComment = commentService.get(no);

    if (oldComment == null) {
      throw new Exception("해당 번호의 댓글이 없습니다.");
    }

    Member loginUser = (Member) request.getSession().getAttribute("loginUser");
    if (loginUser.getNo() != oldComment.getWriter().getNo()) {
      throw new Exception("수정할 권한이 없습니다.");
    }

    Comment comment = new Comment();
    comment.setNo(no);
    comment.setContent(content);

    commentService.update(comment);

    return "redirect:../detail?no=" + feedNo;
  }

}
