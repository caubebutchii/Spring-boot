package com.namvu.buoi4.entity;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User{
    private int id;
    @NotBlank(message = "Please add name for user")
    private String name;
    private String add;


}
