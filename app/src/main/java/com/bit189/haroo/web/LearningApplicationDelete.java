//package com.bit189.haroo.web;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.io.StringWriter;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import com.bit189.haroo.domain.LearningApplication;
//import com.bit189.haroo.service.LearningApplicationService;
//
//@SuppressWarnings("serial")
//@WebServlet("/application/delete")
//public class LearningApplicationDelete extends HttpServlet {
//
//  @Override
//  protected void doGet(HttpServletRequest request, HttpServletResponse response)
//      throws ServletException, IOException {
//
//    LearningApplicationService learningApplicationService = (LearningApplicationService)
//        request.getServletContext().getAttribute("learningApplicationService");
//
//    response.setContentType("text/html;charset=UTF-8");
//    PrintWriter out = response.getWriter();
//
//    out.println("<!DOCTYPE html>");
//    out.println("<html>");
//    out.println("<head>");
//    out.println("<title>체험신청 환불</title>");
//
//    try {
//      // 나중에 날짜로 바꾸기
//      int no = Integer.parseInt(request.getParameter("no"));
//
//      LearningApplication l = learningApplicationService.get(no);
//
//      if (l == null) {
//        throw new Exception("");
//      }
//      learningApplicationService.delete(no);
//
//
//    } catch (Exception e) {
//      StringWriter strWriter = new StringWriter();
//      PrintWriter printWriter = new PrintWriter(strWriter);
//      e.printStackTrace(printWriter);
//
//      out.println("</head>");
//      out.println("<body>");
//      out.println("<h1>체험신청 환불 오류</h1>");
//      out.printf("<p>%s</p>\n", e.getMessage());
//      out.printf("<pre>%s</pre>\n", strWriter.toString());
//      out.println("<p><a href='list'>신청 목록</a></p>");
//    }
//
//    out.println("</body>");
//    out.println("</html>");
//  }
//}
