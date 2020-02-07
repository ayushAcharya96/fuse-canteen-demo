package com.demoproject.fusecanteen.controller;

import com.demoproject.fusecanteen.document.User;
import com.demoproject.fusecanteen.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> getAll() {
        List<User> users = userRepository.findAll();
        System.out.println(users.toString());
        return users;
    }
    @PostMapping
    public void insert(@RequestBody User user) {
        System.out.println(user.toString());
        userRepository.save(user);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") String id) {
        userRepository.deleteById(id);
    }
}
