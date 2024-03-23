package com.namvu.springboot2.controller;

import com.namvu.springboot2.repository.ListUser;
import com.namvu.springboot2.request.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class TestController {
    private ListUser list;
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public List<User> getUsers()
    {
        list = new ListUser();
        return list.getUsers();
    }


    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public User getUsers1(@PathVariable("id") long id)
    {
        list = new ListUser();
        User u;
        for(User x: list.getUsers())
            if(x.getId() == id) {
                u = x;
                return u;
            }
        return null;
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public List<User> getUsers3()
    {
        list = new ListUser();
        return list.getUsers();
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public List<User> getUsers4()
    {
        list = new ListUser();
        return list.getUsers();
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public String getUsers5(@PathVariable("id") long id)
    {
        list = new ListUser();
        User u = null;
        for(User x: list.getUsers())
            if(x.getId() == id) {
                u = x;
                break;
            }
        return "Đã xóa user: " + u.toString();
    }
}
