package com.bit189.haroo.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserInfoHandler {

  @RequestMapping("/userInfo")
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    return "/jsp/user_info.jsp";

  }
}






