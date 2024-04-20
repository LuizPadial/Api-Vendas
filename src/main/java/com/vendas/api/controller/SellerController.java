package com.vendas.api.controller;

import com.vendas.domain.model.Seller;
import com.vendas.domain.repository.SellerRepository;
import com.vendas.domain.services.BusinessService;
import com.vendas.domain.services.SellerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/sellers")
public class SellerController {

   @Autowired
   private final SellerRepository sellerRepository;
   private final BusinessService businessService;

   private SellerService sellerService;
   @GetMapping()
   public ResponseEntity<List<Seller>> listSellers(){
      return ResponseEntity.status(200).body(sellerService.listSellers());
   }
   @PostMapping
   public ResponseEntity<Seller> createSeller(@RequestBody Seller seller){
      return ResponseEntity.status(201).body(sellerService.createSeller(seller));
   }

   @PutMapping
   public ResponseEntity<Seller> editSeller(@RequestBody Seller seller){
      return ResponseEntity.status(200).body(sellerService.editSeller(seller));
   }

   @DeleteMapping("/{id}")
   public ResponseEntity<?> deleteSeller(@PathVariable Long id){
      sellerService.deleteSeller(id);
      return ResponseEntity.status(204).build();
   }

   @GetMapping(value = "/{id}")
   public ResponseEntity<Seller> findById(@PathVariable Long id){
      return ResponseEntity.ok().body(sellerService.buscarPorId(id));
   }
   @GetMapping("/total")
   public ResponseEntity<Map<String, Object>> getSellersSalesReport(
           @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
           @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {

      Map<String, Object> sellersSalesReport = businessService.getSellersSalesReport(startDate, endDate);

      return new ResponseEntity<>(sellersSalesReport, HttpStatus.OK);
   }

}
