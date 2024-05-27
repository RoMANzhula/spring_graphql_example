package org.romanzhula.spring_graphql_example.controllers;

import org.romanzhula.spring_graphql_example.models.Seller;
import org.romanzhula.spring_graphql_example.repositories.SellerRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class SellerController {

    private final SellerRepository sellerRepository;

    public SellerController(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    @QueryMapping
    public Iterable<Seller> sellers() {
        return this.sellerRepository.findAll();
    }

    @QueryMapping
    public Seller sellerById(
        @Argument Long id
    ) {
        return this.sellerRepository.findById(id).orElseThrow();
    }

    @QueryMapping
    public Seller sellerByEmail(
        @Argument String email
    ) {
        return this.sellerRepository.findSellerByEmail(email);
    }
}
