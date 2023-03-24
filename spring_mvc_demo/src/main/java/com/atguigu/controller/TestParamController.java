package com.atguigu.controller;

import com.atguigu.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class TestParamController {

    @RequestMapping("/param/servletAPI")
    public String getParamByServletAPI(HttpServletRequest request) {
        // 在浏览器中设置 JSESSIONID 的 cookie
        HttpSession session = request.getSession();

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username: " + username + ", password: " + password);
        return "success";
    }

    @RequestMapping("/param/servletAPI2")
    public String getParamByServletAPI2(String username, String password) {
        System.out.println("username: " + username + ", password: " + password);
        return "success";
    }

    @RequestMapping("/param/servletAPI3")
    public String getParamByServletAPI3(@RequestParam("name") String username, String password) {
        System.out.println("username: " + username + ", password: " + password);
        return "success";
    }

    @RequestMapping("/param/servletAPI4")
    public String getParamByServletAPI4(
            @RequestParam(defaultValue = "hello") String username,
            String password,
            @RequestHeader("referer") String referer,
            @CookieValue("JSESSIONID") String jSessionId
    ) {
        System.out.println("username: " + username + ", password: " + password);
        System.out.println("referer: " + referer);
        System.out.println("jSessionId: " + jSessionId);
        return "success";
    }

    @RequestMapping("/param/pojo")
    public String getParamByServletAPI3(User user) {
        System.out.println(user);
        return "success";
    }

}
