package com.demoproject.fusecanteen.service;

import com.demoproject.fusecanteen.document.Food;
import com.demoproject.fusecanteen.document.Order;
import com.demoproject.fusecanteen.document.RequestedFood;
import org.springframework.stereotype.Service;

import javax.jws.Oneway;
import java.util.*;

@Service
public class OrderService {

    public static Queue<Order> orderQueue = new LinkedList<Order>();
    public static List<RequestedFood> requestedFoods = new ArrayList<>();

    public Order updateTotalPrice(Order order) {
        List<Food> foods = order.getOrders();
        double price = 0;
        for(Food food : foods) {
            price += food.getPrice();
        }
        order.setTotalPrice(price);
        return order;
    }
}
