package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class TestScopeController {

    @RequestMapping("/test/mav")
    public ModelAndView testMAV() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("testRequestScope", "hello ModelAndView");
        modelAndView.setViewName("success");
        return modelAndView;
    }

    @RequestMapping("/test/model")
    public String testModel(Model model) {
        model.addAttribute("testRequestScope", "hello Model");
        return "success";
    }

    @RequestMapping("/test/modelMap")
    public String testModelMap(ModelMap modelMap) {
        modelMap.addAttribute("testRequestScope", "hello ModelMap");
        return "success";
    }

    @RequestMapping("/test/map")
    public String testModelMap(Map<String, Object> map) {
        System.out.println(map.getClass().getName());
        map.put("testRequestScope", "hello Map");
        return "success";
    }

    @RequestMapping("/test/session")
    public String testSession(HttpSession httpSession) {
        httpSession.setAttribute("testSessionScope", "hello HttpSession");
        return "success";
    }

    @RequestMapping("/test/application")
    public String testApplication(HttpSession httpSession) {
        ServletContext servletContext = httpSession.getServletContext();
        servletContext.setAttribute("testApplicationScope", "hello Application");
        return "success";
    }

}
