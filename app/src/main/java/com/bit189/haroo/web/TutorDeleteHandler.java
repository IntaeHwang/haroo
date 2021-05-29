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
@WebServlet("/tutor/delete")
public class TutorDeleteHandler extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    TutorService tutorService = (TutorService) request.getServletContext().getAttribute("tutorService");

    try {
      int no = Integer.parseInt(request.getParameter("no"));

      Tutor tutor = tutorService.get(no);
      if (tutor == null) {
        throw new Exception("해당 번호의 튜터가 없습니다.");
      }

      tutorService.delete(no);

      response.sendRedirect("list");

    } catch (Exception e) {
      throw new ServletException(e);
    }
  }
}






