package com.vendas.api.mapper;

import com.vendas.api.requestDTO.OrderRequest;
import com.vendas.api.requestDTO.SellerRequest;
import com.vendas.api.responseDTO.OrderResponse;
import com.vendas.api.responseDTO.SellerResponse;
import com.vendas.domain.model.Order;
import com.vendas.domain.model.Seller;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class OrderMapper {

    private final ModelMapper mapper;

    public Order toOrder(OrderRequest request) {
        return mapper.map(request, Order.class);

    }

    public OrderResponse toOrderResponse(Order order) {
        return mapper.map(order, OrderResponse.class);
    }

    public List<OrderResponse> toOrderResponseList(List<Order> orders) {
        return orders.stream()
                .map(this::toOrderResponse)
                .collect(Collectors.toList());
    }

}
