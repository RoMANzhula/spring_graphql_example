package org.romanzhula.spring_graphql_example.repositories;

import org.romanzhula.spring_graphql_example.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
