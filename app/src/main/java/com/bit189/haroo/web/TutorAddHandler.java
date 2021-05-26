package com.bit189.haroo.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bit189.haroo.domain.Member;
import com.bit189.haroo.domain.Tutor;
import com.bit189.haroo.service.TutorService;

@SuppressWarnings("serial")
@MultipartConfig(maxFileSize = 1024 * 1024 * 10)
@WebServlet("/tutor/add")
public class TutorAddHandler extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    response.setContentType("text/html;charset=UTF-8");
    request.getRequestDispatcher("/jsp/tutor/form.jsp").include(request, response);
  }

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {

    TutorService tutorService = (TutorService) request.getServletContext().getAttribute("tutorService");

    try {
      Tutor t = new Tutor();
      Member m = new Member();

      t.setIntro(request.getParameter("tintro"));
      t.setApplication(request.getParameter("tappl"));

      m.setRank(2);

      tutorService.add(t);
      response.sendRedirect("list");
    }catch (Exception e) {
      throw new ServletException(e);
    }

  }
}






