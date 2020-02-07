package com.demoproject.fusecanteen.controller;

import com.demoproject.fusecanteen.document.Food;
import com.demoproject.fusecanteen.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/foods")
public class FoodController {
    @Autowired
    private FoodRepository foodRepository;

    @GetMapping("/all")
    public List<Food> getAll() {
        List<Food> foods = this.foodRepository.findAll();

        return foods;
    }
    @PostMapping
    public void insert(@RequestBody Food food) {
        foodRepository.insert(food);
    }

    @PutMapping
    public void update(@RequestBody Food food) {
        foodRepository.save(food);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        foodRepository.deleteById(id);
    }

}
