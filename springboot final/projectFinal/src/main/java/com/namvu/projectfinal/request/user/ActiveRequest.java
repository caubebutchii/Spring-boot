package com.namvu.projectfinal.request.user;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ActiveRequest
{
    @NotBlank(message = "userID is required")
    private String userID;
    @NotBlank(message = "token is required")
    private String token;
}
