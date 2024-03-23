package com.namvu.springboot2.request;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    private long id;
    private String name;
}
