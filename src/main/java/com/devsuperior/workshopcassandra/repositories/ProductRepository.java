package com.devsuperior.workshopcassandra.repositories;

import com.devsuperior.workshopcassandra.model.entities.Product;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.List;
import java.util.UUID;

public interface ProductRepository extends CassandraRepository<Product, UUID> {

    @AllowFiltering
    List<Product> findByDepartment(String department);

    @AllowFiltering
    List<Product> findProductsByDescription(String description);
}
