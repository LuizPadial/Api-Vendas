package com.vendas.api.responseDTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vendas.domain.model.Order;
import jakarta.persistence.OneToMany;
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
public class SellerResponse {

    private Long id;
    private String name;

}
