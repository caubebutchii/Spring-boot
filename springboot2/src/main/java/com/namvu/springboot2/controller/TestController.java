package com.namvu.springboot2.controller;

import com.namvu.springboot2.entity.User;
import lombok.extern.log4j.Log4j2;
import org.apache.coyote.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Log4j2
public class TestController {
    private List<User> users;
//    Logger log = LoggerFactory.getLogger(TestController.class);
    public TestController()
    {
        users = new ArrayList<>();

        users.add(new User(1, "Khoi", "Quang Ngai"));
        users.add(new User(2, "Nhung", "Sai Gon"));
        users.add(new User(3, "Doan",  "Sai Gon"));
        users.add(new User(4, "Quynh",  "Binh Son"));
        users.add(new User(5, "Uyen", "Nghia Lam"));
        users.add(new User(6, "Ngoc",  "Binh Chanh"));
        users.add(new User(7, "Cong",  "Sai Gon"));
        users.add(new User(8, "Khoi",  "Sai Gon"));
    }

//    @RequestMapping(value = "/user", method = RequestMethod.GET)
//    public List<User> getUsers()
//    {
//        return users;
//    }

//
//    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
//    public User getUsers1(@PathVariable("id") long id)
//    {
//        return users.get((int) id);
//    }
//
//    @RequestMapping(value = "/user", method = RequestMethod.POST)
//    public List<User> getUsers3()
//    {
//        return users;
//    }
//
    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public User  updateUser(@PathVariable int id, @RequestBody User updatedUser)
    {
        for (User user : users) {
            if (user.getId() == id) {
                user.setName(updatedUser.getName());
                return user;
            }
        }
        return null;
    }
//
    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public User getUsers5(@PathVariable("id") long id)
    {
        User u = null;
        for(User u1 : users)
        {
            if (u1.getId() == id) {
                u = u1;
                break;
            }
        }
        users.remove(u);
        return u;
    }
//
    // bai 3
    @PostMapping("/user")
    public User addUser(@RequestBody User user)
    {
        users.add(user);
        return user;
    }

//    @GetMapping(value = "/user")
//    public List<User> searchUser(@RequestParam String name)
//    {
//        List<User> users1;
//        users1 = users.stream()
//                .filter((user) -> user.getName().contains("name"))
//                .collect(Collectors.toList());
//        return users1;
//    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUser(@PathVariable int id)
    {
        User u = null;
        for(User u1 : users)
        {
            if (u1.getId() == id) {
                u = u1;
                break;
            }
        }
        log.info(">>> user: {}", u);
        return new ResponseEntity<User>(u, HttpStatus.OK);
//        return ResponseEntity.badRequest().body(u);
//        return ResponseEntity.status(HttpStatus.OK).body(u);
    }

    @GetMapping("/user")
    public ResponseEntity<List<User>> getListUsers()
    {
        log.info(">>> list users: {}", users);
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }
}
