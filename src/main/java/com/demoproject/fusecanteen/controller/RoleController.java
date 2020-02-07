package com.demoproject.fusecanteen.controller;

import com.demoproject.fusecanteen.document.Role;
import com.demoproject.fusecanteen.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/roles")
public class RoleController {

    @Autowired
    private RoleRepository roleRepository;

    @GetMapping
    public List<Role> getAll() {
        List<Role> roles = roleRepository.findAll();
        return roles;
    }

    @PostMapping("/add")
    public void insert(@RequestBody Role role) {
        System.out.println(role);
//        roleRepository.save(new Role("Employee"));
        roleRepository.save(role);
    }


    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") String id) {
        roleRepository.deleteById(id);
    }
}
