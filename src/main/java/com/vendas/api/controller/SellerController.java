package com.vendas.api.controller;

import com.vendas.domain.model.Seller;
import com.vendas.domain.repository.SellerRepository;
import com.vendas.domain.services.SellerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/sellers")
public class SellerController {

   @Autowired
   private final SellerRepository sellerRepository;

   private SellerService sellerService;
   @GetMapping
   public ResponseEntity<List<Seller>> listSellers(){
      List<Seller> list = sellerRepository.findAll();
      return ResponseEntity.status(200).body(list);
   }
   @PostMapping ResponseEntity<Seller> createSeller(@RequestBody Seller seller){
      Seller newSeller = sellerRepository.save(seller);
      return ResponseEntity.status(201).body(newSeller);
   }

}
