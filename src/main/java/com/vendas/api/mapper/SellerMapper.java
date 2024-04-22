package com.vendas.api.mapper;

import com.vendas.api.requestDTO.SellerRequest;
import com.vendas.api.responseDTO.SellerResponse;
import com.vendas.domain.model.Seller;

import java.util.ArrayList;
import java.util.List;

public class SellerMapper {

    public static Seller toSeller(SellerRequest request){
        Seller seller = new Seller();
        seller.setName(request.getName());
        seller.setOrders(request.getOrders());
        return seller;
    }

    public static SellerResponse toSellerResponse(Seller seller){
        SellerResponse response = new SellerResponse();
        response.setId(seller.getId());
        response.setName(seller.getName());
        return response;
    }

    public static List<SellerResponse> toSellerResponseList(List<Seller> sellers) {
        List<SellerResponse> responses = new ArrayList<>();
        for (Seller seller : sellers){
            responses.add(toSellerResponse(seller));
        }
        return responses;
    }
}
