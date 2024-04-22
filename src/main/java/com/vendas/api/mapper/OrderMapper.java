package com.vendas.api.mapper;

import com.vendas.api.requestDTO.OrderRequest;
import com.vendas.domain.model.Order;

public class OrderMapper {

    public static Order toOrder(OrderRequest request){
        Order order = new Order();
        order.setDate(request.getDate());
        order.setPrice(request.getPrice());
        order.setSeller(request.getSeller());
        return order;
    }


}
