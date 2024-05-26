package org.romanzhula.spring_graphql_example.repositories;

import org.romanzhula.spring_graphql_example.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findCustomerById(Long id);

    Customer findCustomerByEmail(String email);

    boolean existsByEmail(String email);

}
