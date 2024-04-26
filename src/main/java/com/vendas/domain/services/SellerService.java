package com.vendas.domain.services;

import com.vendas.domain.exceptions.DomainExceptions;
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

    public List<Seller> listSellers() {
        List<Seller> sellers = sellerRepository.findAll();
        if (sellers.isEmpty()) {
            throw new DomainExceptions("Não há vendedores disponíveis no momento");
        }
        return sellers;
    }

    public Seller createSeller(Seller seller) {
        if (sellerRepository.findByName(seller.getName()).isPresent()) {
            throw new DomainExceptions("Já existe um vendedor com o nome " + seller.getName());
        }

        return sellerRepository.save(seller);
    }


    public Seller editSeller(Seller seller) {
        return sellerRepository.save(seller);
    }

    public Seller buscarPorId(Long id) {
        Optional<Seller> obj = sellerRepository.findById(id);
        return obj.orElse(null);
    }

    public Boolean deleteSeller(Long id) {
        sellerRepository.deleteById(id);
        return true;
    }

}
