package org.romanzhula.spring_graphql_example.repositories;

import org.romanzhula.spring_graphql_example.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, String> {

}
