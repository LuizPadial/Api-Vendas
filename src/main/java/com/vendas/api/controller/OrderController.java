package com.vendas.api.controller;

import com.vendas.api.mapper.OrderMapper;
import com.vendas.api.requestDTO.OrderRequest;
import com.vendas.api.responseDTO.OrderResponse;
import com.vendas.domain.exceptions.DomainExceptions;
import com.vendas.domain.model.Order;
import com.vendas.domain.services.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/orders")
public class OrderController {


    private OrderService orderService;
    private OrderMapper mapper;

    @GetMapping()
    public ResponseEntity<List<OrderResponse>> listOrders() {
        List<Order> orders = orderService.listOrders();
        List<OrderResponse> orderResponses = mapper.toOrderResponseList(orders);
        return ResponseEntity.status(200).body(orderResponses);
    }

    @PostMapping
    public ResponseEntity<OrderResponse> createOrder(@RequestBody OrderRequest request) {
        Order order = mapper.toOrder(request);
        Order orderCreated = orderService.createOrder(order);
        OrderResponse orderResponse = mapper.toOrderResponse(orderCreated);
        return ResponseEntity.status(201).body(orderResponse);
    }

    @PutMapping
    public ResponseEntity<OrderResponse> editOrder(@RequestBody OrderRequest request) {
        Order order = mapper.toOrder(request);
        Order orderCreated = orderService.createOrder(order);
        OrderResponse orderResponse = mapper.toOrderResponse(orderCreated);
        return ResponseEntity.status(200).body(orderResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
        return ResponseEntity.status(204).build();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<OrderResponse>> findById(@PathVariable Long id) {
        Optional<Order> optOrder = Optional.ofNullable(orderService.buscarPorId(id));
        if (optOrder.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(200).body(Optional.of(mapper.toOrderResponse(optOrder.get())));
    }

}
