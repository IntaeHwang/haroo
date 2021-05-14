package com.bit189.haroo.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bit189.haroo.domain.LearningApplication;
import com.bit189.haroo.domain.LearningSchedule;
import com.bit189.haroo.service.LearningApplicationService;

@SuppressWarnings("serial")
@WebServlet("/application/add")
public class LearningApplicationAddHandler extends HttpServlet{

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    LearningSchedule scheduleService = (LearningSchedule)
        request.getServletContext().getAttribute("scheduleService");

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    try {
      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head>");
      out.println("<meta charset='UTF-8'>");
      out.println("<title>체험 신청</title>");
      out.println("</head>");
      out.println("<body>");
      out.println("<h1>체험 신청</h1>");
      out.println("<form action='add' method='post'>");
      out.println("날짜: <input type='date' name='schedule'><br>");
      out.println("인원: <input type='number' name='applySize'><br>");
      out.println("회차: <input type='time' name='registeredDate'><br>");

      //      List<LearningSchedule> schedules = scheduleService.list(null);
      //      for (LearningSchedule l : schedules) {
      //        out.printf("<input type='checkbox' name='schedule' value='%s'>%s<br>\n", l.getSchedul);
      //      }
    } catch (Exception e) {
      throw new ServletException(e);
    }
    out.println("<p><input type='submit' value='신청'>");

    out.println("</form>");
    out.println("</body>");
    out.println("</html>");
  }


  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    LearningApplicationService learningApplicationService = (LearningApplicationService)
        request.getServletContext().getAttribute("learningApplicationService");


    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>체험신청 등록</title>");


    try {

      LearningApplication l = new LearningApplication();

      List<LearningSchedule> schedule = (List<LearningSchedule>) new LearningSchedule();
      ((LearningSchedule) schedule).setLearningDate(Date.valueOf(request.getParameter("schedule")));
      l.setSchedules(schedule);

      l.setApplySize(Integer.parseInt(request.getParameter("applySize")));
      l.setRegisteredDate(Date.valueOf(request.getParameter("registerDate")));

      learningApplicationService.add(l);

      out.println("<meta http-equiv='Refresh' content='1;url=list'>");
      out.println("</head>");
      out.println("<body>");
      out.println("<h1>체험신청 등록</h1>");
      out.println("<p>체험신청을 등록했습니다.</p>");


    } catch (Exception e) {

      StringWriter strWriter = new StringWriter();
      PrintWriter printWriter = new PrintWriter(strWriter);
      e.printStackTrace(printWriter);

      out.println("</head>");
      out.println("<body>");
      out.println("<h1>체험신청 등록 오류</h1>");
      out.printf("<pre>%s</pre>\n", strWriter.toString());
      out.println("<p><a href='list'>신청 목록</a></p>");
    }

    out.println("</body>");
    out.println("<html>");

  }
}
