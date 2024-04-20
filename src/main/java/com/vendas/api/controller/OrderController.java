package com.vendas.api.controller;

import com.vendas.domain.model.Order;
import com.vendas.domain.repository.OrderRepository;
import com.vendas.domain.services.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/orders")
public class OrderController {


    private OrderService orderService;
    @GetMapping()
    public ResponseEntity<List<Order>> listOrders(){
        return ResponseEntity.status(200).body(orderService.listOrders());
    }
    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order){
        return ResponseEntity.status(201).body(orderService.createOrder(order));
    }

    @PutMapping
    public ResponseEntity<Order> editOrder(@RequestBody Order order){
        return ResponseEntity.status(200).body(orderService.editOrder(order));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable Long id){
        orderService.deleteOrder(id);
        return ResponseEntity.status(204).build();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Order> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(orderService.buscarPorId(id));
    }



}
