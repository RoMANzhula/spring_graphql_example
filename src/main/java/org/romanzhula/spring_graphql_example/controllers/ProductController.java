package org.romanzhula.spring_graphql_example.controllers;

import org.romanzhula.spring_graphql_example.models.Product;
import org.romanzhula.spring_graphql_example.repositories.ProductRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @QueryMapping
    public Iterable<Product> products() {
        return this.productRepository.findAll();
    }

    @QueryMapping
    public Product productById(
        @Argument String id
    ) {
        return this.productRepository.findById(id).orElseThrow();
    }
}
