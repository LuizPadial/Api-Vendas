package com.vendas.domain.services;

import com.vendas.domain.model.Order;
import com.vendas.domain.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public List<Order> listOrders(){
        List<Order> list = orderRepository.findAll();
        return list;

    }
    public Order createOrder(Order order) {
        Order newOrder = orderRepository.save(order);
        return newOrder;
    }

    public Order editOrder(Order order) {
        Order newOrder = orderRepository.save(order);
        return newOrder;
    }

    public Order buscarPorId(Long id){
        Optional<Order> obj = orderRepository.findById(id);
        return obj.orElse(null);
    }

    public Boolean deleteOrder(Long id){
        orderRepository.deleteById(id);
        return true;
    }




}
