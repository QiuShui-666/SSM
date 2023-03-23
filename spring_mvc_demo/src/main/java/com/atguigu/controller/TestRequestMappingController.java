package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
//@RequestMapping("/test")
public class TestRequestMappingController {

    @RequestMapping(
            value = {"/hello", "/abc"},
            method = {RequestMethod.GET, RequestMethod.POST},
//            params = {"username", "!password", "age=20", "gender!=女"}
            headers = {"referer"}
    )
    public String hello() {
        return "success";
    }

    @RequestMapping("/**/rest/ant")
    public String testAnt() {
        return "success";
    }

    @RequestMapping("/test/rest/{username}/{id}")
    public String testRest(@PathVariable("username") String username, @PathVariable("id") Integer id) {
        System.out.println("id: " + id + ", username: " + username);
        return "success";
    }



}
