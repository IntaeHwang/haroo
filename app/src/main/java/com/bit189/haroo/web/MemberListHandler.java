package com.bit189.haroo.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bit189.haroo.domain.Member;
import com.bit189.haroo.service.MemberService;

@SuppressWarnings("serial")
@WebServlet("/member/list") 
public class MemberListHandler extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    MemberService memberService = (MemberService) request.getServletContext().getAttribute("memberService");

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>회원 목록</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>회원 목록</h1>");

    out.println("<p><a href='form.html'>회원등록</a></p>");

    try {
      List<Member> list = memberService.list(request.getParameter("keyword"));

      out.println("<table border='1'>");
      out.println("<thead>");
      out.println("<tr>");
      out.println("<th>번호</th> <th>이름</th> <th>이메일</th> <th>사진</th>"
          + " <th>전화번호</th> <th>닉네임</th> <th>성별</th>");
      out.println("</tr>");
      out.println("</thead>");
      out.println("<tbody>");

      for (Member m : list) {
        out.printf("<tr>"
            + " <td>%d</td>"
            + " <td>%s</td>"
            + " <td><a href='detail?no=%1$d'>%s</a></td>"
            + "  <td><img src='%s'></td>"
            + " <td>%s</td>"
            + " <td>%s</td>"
            + " <td>%s</td> </tr>\n",
            m.getNo(), 
            m.getName(), 
            m.getEmail(),
            m.getProfilePicture() != null ? "../upload/" + m.getProfilePicture() + "_30x30.jpg" : "../images/person_30x30.jpg",
                m.getTel(),
                m.getNickname(),
                Member.getStatusLabel(m.getSex()));
      }
      out.println("</tbody>");
      out.println("</table>");

      out.println("<form action='list' method='get'>");
      String keyword = request.getParameter("keyword");
      out.printf("<input type='search' name='keyword' value='%s'> \n", 
          keyword != null ? keyword : "");
      out.println("<button>검색</button>");
      out.println("</form>");

    } catch (Exception e) {
      StringWriter strWriter = new StringWriter();
      PrintWriter printWriter = new PrintWriter(strWriter);
      e.printStackTrace(printWriter);
      out.printf("<pre>%s</pre>\n", strWriter.toString());
    }

    out.println("</body>");
    out.println("</html>");
  }

}
