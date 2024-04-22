package com.vendas.api.controller;

import com.vendas.api.mapper.SellerMapper;
import com.vendas.api.requestDTO.SellerRequest;
import com.vendas.api.responseDTO.SellerResponse;
import com.vendas.domain.model.Seller;
import com.vendas.domain.services.BusinessService;
import com.vendas.domain.services.SellerService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/sellers")
public class SellerController {

    private final BusinessService businessService;

   private SellerService sellerService;
   @GetMapping()
   public ResponseEntity<List<SellerResponse>> listSellers(){
      List<Seller> sellers = sellerService.listSellers();
      List<SellerResponse> sellerResponses = SellerMapper.toSellerResponseList(sellers);
      return ResponseEntity.status(200).body(sellerResponses);
   }
   @PostMapping
   public ResponseEntity<SellerResponse> createSeller(@RequestBody SellerRequest request){
      Seller seller = SellerMapper.toSeller(request);
      Seller sellerCreated =sellerService.createSeller(seller);
      SellerResponse sellerResponse = SellerMapper.toSellerResponse(sellerCreated);
      return ResponseEntity.status(201).body(sellerResponse);
   }

   @PutMapping
   public ResponseEntity<SellerResponse> editSeller(@RequestBody SellerRequest request){
      Seller seller = SellerMapper.toSeller(request);
      Seller sellerCreated =sellerService.createSeller(seller);
      SellerResponse sellerResponse = SellerMapper.toSellerResponse(sellerCreated);
      return ResponseEntity.status(200).body(sellerResponse);
   }

   @GetMapping(value = "/{id}")
   public ResponseEntity<Optional<SellerResponse>> findById(@PathVariable Long id){
      Optional<Seller> optSeller = Optional.ofNullable(sellerService.buscarPorId(id));
      if(optSeller.isEmpty()){
         return ResponseEntity.notFound().build();
      }
      return ResponseEntity.status(200).body(Optional.of(SellerMapper.toSellerResponse(optSeller.get())));
   }

   @GetMapping("/total")
   public ResponseEntity<Map<String, Object>> getSellersSalesReport(
           @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
           @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {

      Map<String, Object> sellersSalesReport = businessService.getSellersSalesReport(startDate, endDate);

      return new ResponseEntity<>(sellersSalesReport, HttpStatus.OK);
   }

   @DeleteMapping("/{id}")
   public ResponseEntity<?> deleteSeller(@PathVariable Long id){
      sellerService.deleteSeller(id);
      return ResponseEntity.status(204).build();
   }

}
