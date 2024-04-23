package com.vendas.api.mapper;

import com.vendas.api.requestDTO.SellerRequest;
import com.vendas.api.responseDTO.SellerResponse;
import com.vendas.domain.model.Seller;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class SellerMapper {

    private final ModelMapper mapper;

    public Seller toSeller(SellerRequest request) {
        return mapper.map(request, Seller.class);

    }

    public SellerResponse toSellerResponse(Seller seller) {
        return mapper.map(seller, SellerResponse.class);
    }

    public List<SellerResponse> toSellerResponseList(List<Seller> sellers) {
        return sellers.stream()
                .map(this::toSellerResponse)
                .collect(Collectors.toList());
    }
}
