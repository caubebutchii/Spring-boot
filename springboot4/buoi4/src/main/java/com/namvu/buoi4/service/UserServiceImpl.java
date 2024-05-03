package com.namvu.buoi4.service;

import com.namvu.buoi4.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    ArrayList<User> users;
    public ArrayList<User> createList()
    {
        users = new ArrayList<>();
        users.add(new User(1, "Khoi", "hcm"));
        users.add(new User(2, "Nam", "hcm"));
        users.add(new User(3, "Chanh", "hcm"));
        users.add(new User(4, "Huy", "hcm"));
        users.add(new User(5, "Long", "hcm"));
        return users;
    }
    @Override
    public List<User> getUsers() {
        createList();
        return users;
    }

    @Override
    public User postUser(User user)
    {
        createList();
        users.add(user);
        return user;
    }
}
