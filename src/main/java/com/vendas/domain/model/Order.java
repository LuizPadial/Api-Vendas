package com.vendas.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name ="tb_order")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;

    private Double price ;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    private Seller seller;


}
