package com.chinasoft.mp3_2.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ErrController implements ErrorController {
    @RequestMapping("/")
    public String showIndex(HttpServletRequest request){
        request.setAttribute("name","张顺飞");
        request.getSession().setAttribute("name","李顺爬");
        return  "login";
    }

   @RequestMapping("/error")
   public String  showError(HttpServletRequest request){
       return  getErrorPath();
   }

    @Override
    public String getErrorPath() {
        return "error";
    }
}
