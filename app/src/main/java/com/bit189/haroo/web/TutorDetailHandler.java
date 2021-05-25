package com.bit189.haroo.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bit189.haroo.domain.Tutor;
import com.bit189.haroo.service.TutorService;

@SuppressWarnings("serial")
@WebServlet("/tutor/detail")
public class TutorDetailHandler extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    TutorService tutorService = (TutorService) request.getServletContext().getAttribute("tutorService");

    try {
      int no = Integer.parseInt(request.getParameter("no"));

      Tutor t = tutorService.get(no);
      request.setAttribute("tutor", t);
      response.setContentType("text/html;charset=UTF-8");
      request.getRequestDispatcher("/jsp/tutor/detail.jsp").include(request, response);

    } catch (Exception e) {
      throw new ServletException(e);
    }
  }
}






