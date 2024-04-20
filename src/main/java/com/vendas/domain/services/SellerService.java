package com.vendas.domain.services;

import com.vendas.domain.model.Seller;
import com.vendas.domain.repository.SellerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class SellerService {

    private final SellerRepository sellerRepository;

    public List<Seller> findAll(){
        return sellerRepository.findAll();
    }

    public Seller findbyId(Long id){
        Optional<Seller> obj  = sellerRepository.findById(id);
        return obj.get();
    }

    public Seller insert(Seller obj){
        return sellerRepository.save(obj);
    }



}
