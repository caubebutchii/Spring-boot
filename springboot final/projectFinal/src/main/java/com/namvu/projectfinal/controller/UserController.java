package com.namvu.projectfinal.controller;

import com.namvu.projectfinal.request.user.ActiveRequest;
import com.namvu.projectfinal.request.user.SignUpRequest;
import com.namvu.projectfinal.response.WrapResponse;
import com.namvu.projectfinal.response.user.UserResponse;
import com.namvu.projectfinal.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/user")
@Log4j2
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public WrapResponse<UserResponse> signup(@RequestBody @Valid SignUpRequest request)
    {
        System.out.println(request);
        return WrapResponse.ok(userService.createUser(request));
    }

    @GetMapping("/profile/{id}")
    public WrapResponse<UserResponse> getProfile(@PathVariable String id)
    {
        return WrapResponse.ok(userService.getProfile(id));
    }

    @PostMapping("/active")
    public WrapResponse<UserResponse> active(@RequestBody @Valid ActiveRequest request)
    {
        System.out.println(request);
        return WrapResponse.ok(userService.active(request));
    }
}
