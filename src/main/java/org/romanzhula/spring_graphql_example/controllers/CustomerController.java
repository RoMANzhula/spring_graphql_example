package org.romanzhula.spring_graphql_example.controllers;

import org.romanzhula.spring_graphql_example.models.Customer;
import org.romanzhula.spring_graphql_example.repositories.CustomerRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class CustomerController {

    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @QueryMapping
    public Iterable<Customer> customers() {
        return this.customerRepository.findAll();
    }

    @QueryMapping
    public Customer customerById(
            @Argument Long id
    ) {
        return this.customerRepository.findCustomerById(id).orElseThrow();
    }

    @QueryMapping
    public Customer customerByEmail(
            @Argument String email
    ) {
        return this.customerRepository.findCustomerByEmail(email);
    }
}
