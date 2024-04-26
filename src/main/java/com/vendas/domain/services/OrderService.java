package com.vendas.domain.services;

import com.vendas.domain.exceptions.DomainExceptions;
import com.vendas.domain.model.Order;
import com.vendas.domain.model.Seller;
import com.vendas.domain.repository.OrderRepository;
import com.vendas.domain.repository.SellerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final SellerRepository sellerRepository;

    public List<Order> listOrders(){
        List<Order> list = orderRepository.findAll();
        if (list.isEmpty()) {
            throw new DomainExceptions("Não há pedidos disponíveis no momento");
        }
        return list;
    }


    public Order createOrder(Order order) {
        if (order.getSeller() == null || order.getSeller().getId() == null) {
            throw new DomainExceptions("O ID do vendedor não pode ser nulo");
        }
        Optional<Seller> sellerOptional = sellerRepository.findById(order.getSeller().getId());
        if (!sellerOptional.isPresent()) {
            throw new DomainExceptions("Vendedor com ID " + order.getSeller().getId() + " não encontrado");
        }
        return orderRepository.save(order);
    }

    public Order editOrder(Order order) {
        if (order.getSeller() == null || order.getSeller().getId() == null) {
            throw new DomainExceptions("O ID do vendedor não pode ser nulo");
        }
        Optional<Seller> sellerOptional = sellerRepository.findById(order.getSeller().getId());
        if (!sellerOptional.isPresent()) {
            throw new DomainExceptions("Vendedor com ID " + order.getSeller().getId() + " não encontrado");
        }
        return orderRepository.save(order);
    }

    public Order buscarPorId(Long id){
        Optional<Order> obj = orderRepository.findById(id);
        if (obj.isEmpty()) {
            throw new DomainExceptions("Número de pedido não existe no sistema");
        }
        return obj.orElse(null);
    }

    public Boolean deleteOrder(Long id) {
        Optional<Order> orderOptional = orderRepository.findById(id);
        if (orderOptional.isEmpty()) {
            throw new DomainExceptions("Pedido não existe no sistema");
        }
        orderRepository.deleteById(id);
        return true;
    }





}
