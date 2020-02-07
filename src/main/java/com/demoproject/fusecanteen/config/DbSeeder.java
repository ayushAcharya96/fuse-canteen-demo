package com.demoproject.fusecanteen.config;

import com.demoproject.fusecanteen.document.Food;
import com.demoproject.fusecanteen.document.Role;
import com.demoproject.fusecanteen.document.User;
import com.demoproject.fusecanteen.repository.FoodRepository;
import com.demoproject.fusecanteen.repository.RoleRepository;
import com.demoproject.fusecanteen.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import sun.tools.jar.CommandLine;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class DbSeeder implements CommandLineRunner {

    @Autowired
    private FoodRepository foodRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;
//    public DbSeeder(FoodRepository foodRepository) {
//        this.foodRepository = foodRepository;
//    }

    @Override
    public void run(String... strings) throws Exception {

        this.foodRepository.deleteAll();
        this.roleRepository.deleteAll();
        this.userRepository.deleteAll();

        userRepository.save(new User("ayush", "Admin", "12345"));
        userRepository.save(new User("aashish", "Employee", "12345"));

        roleRepository.save(new Role("Admin"));
        roleRepository.save(new Role("Employee"));

        foodRepository.save(new Food("Buff Momo", 80.00));
        foodRepository.save(new Food("Chicken Momo", 120.00));
        foodRepository.save(new Food("Buff Chowmein", 100));

    }

}
