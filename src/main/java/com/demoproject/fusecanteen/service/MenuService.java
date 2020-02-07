package com.demoproject.fusecanteen.service;

import com.demoproject.fusecanteen.document.Food;
import com.demoproject.fusecanteen.document.Menu;
import com.demoproject.fusecanteen.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {

    @Autowired
    private FoodRepository foodRepository;

    public List<Food> addToMenu(Food food) {
        Menu.menus.add(food);
        return Menu.menus;
    }

    public List<Food> removeFromMenu(String foodId) {
        Menu.menus.remove(foodRepository.findById(foodId));
        return Menu.menus;
    }
}
