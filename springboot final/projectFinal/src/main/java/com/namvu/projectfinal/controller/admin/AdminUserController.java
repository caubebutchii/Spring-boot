package com.namvu.projectfinal.controller.admin;

import com.namvu.projectfinal.request.SearchRequest;
import com.namvu.projectfinal.request.user.AdminUpdateStatusRequest;
import com.namvu.projectfinal.response.WrapResponse;
import com.namvu.projectfinal.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/admin/user")
@Log4j2
public class AdminUserController {
    private final UserService userService;

    public AdminUserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/update-status")
    public WrapResponse<String> updateStatus(@Valid @RequestBody AdminUpdateStatusRequest request)
    {
        return WrapResponse.ok(userService.adminUpdateStatus(request));
    }


    @PostMapping("/search")
    public WrapResponse<Object> search(@Valid @RequestBody SearchRequest request)
    {
        return WrapResponse.ok(userService.search(request));
    }

}
