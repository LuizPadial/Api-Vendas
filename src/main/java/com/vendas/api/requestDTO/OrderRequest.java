package com.vendas.api.requestDTO;

import com.vendas.domain.model.Seller;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {

    private LocalDate date;
    private Double price ;
    private Seller seller;

}
