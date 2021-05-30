package com.bit189.haroo.web;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bit189.haroo.domain.Feed;
import com.bit189.haroo.service.FeedService;

@SuppressWarnings("serial")
@WebServlet("/feed/list")
public class FeedListHandler extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    FeedService feedService = (FeedService) request.getServletContext().getAttribute("feedService");

    try {
      List<Feed> feeds = feedService.list();

      request.setAttribute("feeds", feeds);

      response.setContentType("text/html;charset=UTF-8");
      request.getRequestDispatcher("/jsp/feed/list.jsp").include(request, response);

    } catch (Exception e) {
      throw new ServletException(e);

    }
  }

}





