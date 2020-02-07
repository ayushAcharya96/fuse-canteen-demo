package com.demoproject.fusecanteen.controller;

import com.demoproject.fusecanteen.document.Order;
import com.demoproject.fusecanteen.document.RequestedFood;
import com.demoproject.fusecanteen.repository.OrderRepository;
import com.demoproject.fusecanteen.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<Order> getAll() {
        List<Order> orders = orderRepository.findAll();
        return orders;
    }

    @PostMapping("/add")
    public void insert(@RequestBody Order order) {
        orderRepository.insert(orderService.updateTotalPrice(order));
        OrderService.orderQueue.add(order);
    }
    @PostMapping("/remove")
    public void remove() {
        OrderService.orderQueue.peek().setStatus("READY");
        Order order = OrderService.orderQueue.remove();
        OrderService.orderQueue.peek().setStatus("IN PROCESS");
    }

    @GetMapping("/requested")
    public List<RequestedFood> viewRequestedFood() {
        return OrderService.requestedFoods;
    }

    @PostMapping("/request")
    public List<RequestedFood> requetedFood(@RequestBody RequestedFood requestedFood) {
        OrderService.requestedFoods.add(requestedFood);
        return OrderService.requestedFoods;
    }
}
