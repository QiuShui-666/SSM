package com.atguigu.controller;

import com.atguigu.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Controller
public class TestAjaxController {

    @RequestMapping("/test/ajax")
    public void testAjax(Integer id, @RequestBody String requestBody, HttpServletResponse response) throws IOException {
        System.out.println("requestBody: " + requestBody);
        System.out.println("id: " + id);
        response.getWriter().write("hello, axios");
    }

    @RequestMapping("/test/RequestBody/json")
    public void testRequestBody(
//            @RequestBody User user,
            @RequestBody Map<String, Object> map,
            HttpServletResponse response) throws IOException {
        System.out.println(map);
        response.getWriter().write("hello, requestBody");
    }

    @RequestMapping("/test/ResponseBody")
    @ResponseBody
    public String testResponseBody() {
        return "success";
    }

    @RequestMapping("/test/ResponseBody/json")
    @ResponseBody
    public User testResponseBodyJson() {
        return new User(1001, "admin", "123456", 20, "男");
    }


}
