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
        Long sellerId = seller.getId();
        if (sellerId == null) {
            throw new DomainExceptions("ID do vendedor não fornecido para edição");
        }
        Optional<Seller> existingSellerOptional = sellerRepository.findById(sellerId);
        if (existingSellerOptional.isEmpty()) {
            throw new DomainExceptions("Vendedor com ID " + sellerId + " não encontrado");
        }
        return sellerRepository.save(seller);
    }

    public Seller buscarPorId(Long id) {
        if (id == null) {
            throw new DomainExceptions("ID do vendedor não fornecido para busca");
        }
        Optional<Seller> obj = sellerRepository.findById(id);
        if (!obj.isPresent()) {
            throw new DomainExceptions("Nenhum vendedor encontrado com o ID fornecido: " + id);
        }
        return obj.get();
    }

    public Boolean deleteSeller(Long id) {
        Optional<Seller> existingSellerOptional = sellerRepository.findById(id);
        if (existingSellerOptional.isEmpty()) {
            throw new DomainExceptions("Vendedor com ID " + id + " não encontrado");
        }
        sellerRepository.deleteById(id);
        return true;
    }

}
