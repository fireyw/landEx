package com.example.demo.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.awt.*;

@Controller
public class SampleController {

    @GetMapping("/index")
    public String init(){

        return "index";
    }

    //@RequestMapping(value="/hello", method= {RequestMethod.GET, RequestMethod.PUT})
    //@GetMapping("/hello, consumes="MediaType.JSON")
    @RequestMapping(value="hello", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public String hello(){
        return "hello";
    }

}
