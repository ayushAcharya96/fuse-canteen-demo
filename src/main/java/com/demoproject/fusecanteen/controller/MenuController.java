package com.demoproject.fusecanteen.controller;

import com.demoproject.fusecanteen.document.Food;
import com.demoproject.fusecanteen.document.Menu;
import com.demoproject.fusecanteen.document.Order;
import com.demoproject.fusecanteen.document.RequestedFood;
import com.demoproject.fusecanteen.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private FoodRepository foodRepository;

    @GetMapping
    public List<Food> showMenu() {
        return Menu.menus;
    }

    @PostMapping("/create")
    public List<Food> createMenu(@RequestBody List<Food> foods) {
        Menu.menus = foods;
        return Menu.menus;
    }

    @PostMapping("/add")
    public List<Food> addToMenu(@RequestBody Food food) {
        Menu.menus.add(food);
        return Menu.menus;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteItemFromMenu(@PathVariable("id") String id) {
        Menu.menus.remove(foodRepository.findById(id));
    }

}
