package com.vendas.api.requestDTO;

import com.vendas.domain.model.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SellerRequest {

    private String name;
    private List<Order> orders = new ArrayList<>();

}
