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
//
//@SuppressWarnings("serial")
//@WebServlet("/application/detail")
//public class LearningApplicationDetailHandler extends HttpServlet {
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
//    out.println("<title>신청목록 상세</title>");
//    out.println("</head>");
//    out.println("<body>");
//    out.println("<h1>신청목록 상세보기</h1>");
//
//    try { 
//      int no = Integer.parseInt(request.getParameter("no"));
//
//      LearningApplication learningApplication = learningApplicationService.get(no);
//
//      if (learningApplication == null) {
//        out.println("<p>해당 번호의 신청이 없습니다.</p>");
//        out.println("</body>");
//        out.println("</html>");
//        return;
//      }
//
//      out.println("<form action='update' method='post'>");
//      out.printf("번호: <input type='text' name='no' value='%d'><br>\n", learningApplication.getNo());
//      out.printf("날짜: <input type='date' 'name='schedule' value='%s'><br>\n", learningApplication.getSchedule());
//      out.printf("인원: <input type='number' name='applySize' value='%s'><br>\n", learningApplication.getApplySize());
//      out.printf("회차: <input type='time' name='registeredDate' value='%s'><br>\n", learningApplication.getRegisteredDate());
//
//      //      List<LearningSchedule> schedules = scheduleService.list(null);
//      //      for (LearningSchedule l : schedules) {
//      //        out.printf("<input type='checkbox' name='schedule' value='%s'>%s<br>\n", l.getSchedul);
//      //      }
//
//      out.println("<input type='submit' value='변경'> ");
//      out.printf("<a href='delete?no=%d'>환불</a>\n", learningApplication.getNo());
//      out.println("</form>");
//
//    } catch (Exception e) {
//      StringWriter strWriter = new StringWriter();
//      PrintWriter printWriter = new PrintWriter(strWriter);
//      e.printStackTrace(printWriter);
//      out.printf("<pre>%s</pre>\n", strWriter.toString());
//    }
//    out.println("<p><a href='list'>신청 목록</a></p>");
//
//    out.println("</body>");
//    out.println("</html>");
//  }
//}
