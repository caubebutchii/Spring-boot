package com.namvu.projectfinal.request.user;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignUpRequest {
    @NotBlank(message = "username is required")
    @Pattern(regexp = "^[a-zA-z0-9-_]{6,50}", message = "username wrong format")
    private String username;
    // 8 ki tu, chu hoa- thuong, so, ki tu dac biet
    @Pattern(regexp = "^[a-zA-z0-9-_!@#$%^&*()]{6,50}", message = "password wrong format")
    @NotBlank(message = "password is required")
    private String password;
    @NotBlank(message = "email is required")
    //regex
    private String email;
}
