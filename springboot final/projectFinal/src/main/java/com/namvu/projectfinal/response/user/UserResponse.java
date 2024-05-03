package com.namvu.projectfinal.response.user;


import com.namvu.projectfinal.enumStatic.UserStatus;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponse {
    private String id;
    private String username;
    private String email;
    private String phone;
    private String name;
    private String avatar;
    private UserStatus status;
}
