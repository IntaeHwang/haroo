package com.bit189.haroo.web;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bit189.haroo.domain.Tutor;
import com.bit189.haroo.service.TutorService;

@SuppressWarnings("serial")
@WebServlet("/tutor/list") 
public class TutorListHandler extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    TutorService tutorService = (TutorService) request.getServletContext().getAttribute("tutorService");

    try {
      List<Tutor> list = tutorService.list(request.getParameter("keyword"));

      request.setAttribute("list", list);
      response.setContentType("text/html;charset=UTF-8");
      request.getRequestDispatcher("/jsp/tutor/list.jsp").include(request, response);

    } catch (Exception e) {
      throw new ServletException(e);
    }
  }

}
