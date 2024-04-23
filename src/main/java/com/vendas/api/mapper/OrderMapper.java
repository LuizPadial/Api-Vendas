package com.vendas.api.mapper;

import com.vendas.api.requestDTO.OrderRequest;
import com.vendas.api.responseDTO.OrderResponse;
import com.vendas.api.responseDTO.SellerResponse;
import com.vendas.domain.model.Order;
import com.vendas.domain.model.Seller;

import java.util.ArrayList;
import java.util.List;

public class OrderMapper {

    public static Order toOrder(OrderRequest request){
        Order order = new Order();
        order.setDate(request.getDate());
        order.setPrice(request.getPrice());
        order.setSeller(request.getSeller());
        return order;
    }

    public static OrderResponse toOrderResponse(Order order){
        OrderResponse response = new OrderResponse();
        response.setId(order.getId());
        response.setDate(order.getDate());
        response.setPrice(order.getPrice());
        response.setSeller(order.getSeller());
        return response;
    }


    public static List<OrderResponse> toOrderResponseList(List<Order> orders) {
        List<OrderResponse> responses = new ArrayList<>();
        for (Order order : orders){
            responses.add(toOrderResponse(order));
        }
        return responses;
    }

}
