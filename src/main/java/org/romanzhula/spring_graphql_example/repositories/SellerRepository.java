package org.romanzhula.spring_graphql_example.repositories;

import org.romanzhula.spring_graphql_example.models.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Long> {

    Seller findSellerByEmail(String email);
}
