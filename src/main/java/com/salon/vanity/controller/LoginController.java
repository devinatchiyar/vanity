package com.salon.vanity.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.salon.vanity.model.Login;
import com.salon.vanity.service.UserService;

@Controller
public class LoginController {
  @Autowired
  UserService userService;
  
  @RequestMapping(value = "/", method = RequestMethod.GET)
  
  public ModelAndView showHome(HttpServletRequest request, HttpServletResponse response) {
    ModelAndView mav = new ModelAndView("login");
    return mav;
  }
  
  @RequestMapping(value = "/login", method = RequestMethod.GET)
  
  public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
    ModelAndView mav = new ModelAndView("login");
    mav.addObject("login", new Login());
    return mav;
  }
  
  @RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
  
  public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,
  @ModelAttribute("login") Login login) {
    ModelAndView mav = null;
    int user = userService.validateUser(login);
    if (user == 1) {
    request.getSession().setAttribute("UserName", login.getUsername());
    mav = new ModelAndView("home");
    } else {
    mav = new ModelAndView("login");
    mav.addObject("message", "Username or Password is wrong!!");
    }
    return mav;
  }

  @RequestMapping(value = "/show-home", method = RequestMethod.GET)
  
  public ModelAndView showWomenManipedi(HttpServletRequest request, HttpServletResponse response) {
    ModelAndView mav = new ModelAndView("home");
    return mav;
  }
  
  @RequestMapping(value = "/logout", method = RequestMethod.GET)
  public ModelAndView showLogout(HttpServletRequest request, HttpServletResponse response) {
	 request.getSession().invalidate();
    ModelAndView mav = new ModelAndView("login");
    mav.addObject("login", new Login());
    return mav;
  }
  
}