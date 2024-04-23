package com.vendas.api.controller;

import com.vendas.api.mapper.OrderMapper;
import com.vendas.api.mapper.SellerMapper;
import com.vendas.api.requestDTO.OrderRequest;
import com.vendas.api.requestDTO.SellerRequest;
import com.vendas.api.responseDTO.OrderResponse;
import com.vendas.api.responseDTO.SellerResponse;
import com.vendas.domain.model.Order;
import com.vendas.domain.model.Order;
import com.vendas.domain.model.Seller;
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
//    @GetMapping()
//    public ResponseEntity<List<Order>> listOrders(){
//        return ResponseEntity.status(200).body(orderService.listOrders());
//    }

    @GetMapping()
    public ResponseEntity<List<OrderResponse>> listOrders(){
        List<Order> orders = orderService.listOrders();
        List<OrderResponse> orderResponses = OrderMapper.toOrderResponseList(orders);
        return ResponseEntity.status(200).body(orderResponses);
    }
//    @PostMapping
//    public ResponseEntity<Order> createOrder(@RequestBody Order order){
//        return ResponseEntity.status(201).body(orderService.createOrder(order));
//    }

    @PostMapping
    public ResponseEntity<OrderResponse> createOrder(@RequestBody OrderRequest request){
        Order order = OrderMapper.toOrder(request);
        Order orderCreated =orderService.createOrder(order);
        OrderResponse orderResponse = OrderMapper.toOrderResponse(orderCreated);
        return ResponseEntity.status(201).body(orderResponse);
    }

//    @PutMapping
//    public ResponseEntity<Order> editOrder(@RequestBody Order order){
//        return ResponseEntity.status(200).body(orderService.editOrder(order));
//    }

    @PutMapping
    public ResponseEntity<OrderResponse> editOrder(@RequestBody OrderRequest request){
        Order order = OrderMapper.toOrder(request);
        Order orderCreated =orderService.createOrder(order);
        OrderResponse orderResponse = OrderMapper.toOrderResponse(orderCreated);
        return ResponseEntity.status(200).body(orderResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable Long id){
        orderService.deleteOrder(id);
        return ResponseEntity.status(204).build();
    }

//    @GetMapping(value = "/{id}")
//    public ResponseEntity<Order> findById(@PathVariable Long id){
//        return ResponseEntity.ok().body(orderService.buscarPorId(id));
//    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<OrderResponse>> findById(@PathVariable Long id){
        Optional<Order> optOrder = Optional.ofNullable(orderService.buscarPorId(id));
        if(optOrder.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(200).body(Optional.of(OrderMapper.toOrderResponse(optOrder.get())));
    }




}
