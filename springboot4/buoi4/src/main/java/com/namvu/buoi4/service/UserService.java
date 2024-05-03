package com.namvu.buoi4.service;

import com.namvu.buoi4.entity.User;

import java.util.ArrayList;
import java.util.List;

public interface UserService {
    List<User> getUsers();
    User postUser(User user);
}
