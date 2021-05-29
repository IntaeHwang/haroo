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
import com.bit189.haroo.domain.TutorCategory;
import com.bit189.haroo.domain.TutorDistrict;
import com.bit189.haroo.service.MemberService;
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
    MemberService memberService = (MemberService) request.getServletContext().getAttribute("memberService");
    try {
      TutorCategory tc = new TutorCategory();
      TutorDistrict td = new TutorDistrict();
      Tutor t = new Tutor();
      Member m = new Member();
      t.setNo(Integer.parseInt(request.getParameter("tno")));

      //      if (  == null) {
      //        throw new Exception("해당번호의 멤버가 없습니다.");
      //      }

      t.setIntro(request.getParameter("tintro"));
      t.setApplication(request.getParameter("tappl"));

      m.setNo(Integer.parseInt(request.getParameter("tno")));

      td.setTno(Integer.parseInt(request.getParameter("tno")));
      td.setSigunguNo(Integer.parseInt(request.getParameter("sgg_no")));

      tc.setTno(Integer.parseInt(request.getParameter("tno")));
      tc.setNarrowCategoryNo(Integer.parseInt(request.getParameter("ncat_no")));
      tutorService.add(t, m, td, tc);

      response.sendRedirect("list");
    }catch (Exception e) {
      throw new ServletException(e);
    }

  }
}






