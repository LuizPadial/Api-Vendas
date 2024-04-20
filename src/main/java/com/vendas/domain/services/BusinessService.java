package com.vendas.domain.services;

import com.vendas.domain.repository.OrderRepository;
import com.vendas.domain.repository.SellerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
@AllArgsConstructor
@Service
public class BusinessService {

    private final OrderRepository orderRepository;
    private final SellerRepository sellerRepository;


}
