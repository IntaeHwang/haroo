package com.bit189.haroo.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bit189.haroo.service.Sample_MemberService;

@SuppressWarnings("serial")
//@WebServlet("/member/delete")
public class Sample_MemberDeleteHandler extends HttpServlet {

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    Sample_MemberService memberService = (Sample_MemberService) request.getServletContext().getAttribute("memberService");

    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("[회원 삭제]");

    try {
      int no = Integer.parseInt(request.getParameter("no"));

      if (memberService.delete(no) == 0) {
        out.println("해당 번호의 회원이 없습니다.");
      } else {
        out.println("회원을 삭제하였습니다.");
      }
    } catch (Exception e) {
      StringWriter strWriter = new StringWriter();
      PrintWriter printWriter = new PrintWriter(strWriter);
      e.printStackTrace(printWriter);
      out.println(strWriter.toString());
    }
  }
}






