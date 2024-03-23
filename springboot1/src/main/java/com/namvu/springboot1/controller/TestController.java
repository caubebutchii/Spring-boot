package com.namvu.springboot1.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.namvu.springboot1.request.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class TestController {

    @GetMapping("/hello")
    public String hello()
    {
        return "hello";
    }

    @PostMapping("/hello")
    public String helloUser(@RequestBody User body)
    {
        System.out.println(body.getName());
        return body.getName();
    }


}
