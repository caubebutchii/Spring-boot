package com.namvu.projectfinal.entity;

import com.namvu.projectfinal.enumStatic.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "tb_user")
public class User {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String username;
    private String password;
    private String email;
    private String phone;
    private String name;
    private String nameSearch;
    private String avatar;
    @Enumerated(EnumType.STRING)
    private UserStatus status;
}
