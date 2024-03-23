package com.namvu.springboot2.repository;

import com.namvu.springboot2.request.User;

import java.util.ArrayList;
import java.util.List;

public class ListUser {

    public List<User> getUsers()
    {
        List<User> list = new ArrayList<>();
        list.add(new User(1, "Nam1"));
        list.add(new User(2, "Nam2"));
        list.add(new User(3, "Nam3"));
        list.add(new User(4, "Nam4"));
        return list;
    }
}
