package com.devsuperior.workshopcassandra.services;

import com.devsuperior.workshopcassandra.model.dtos.DepartmentDTO;
import com.devsuperior.workshopcassandra.model.dtos.ProductDTO;
import com.devsuperior.workshopcassandra.model.entities.Department;
import com.devsuperior.workshopcassandra.model.entities.Product;
import com.devsuperior.workshopcassandra.repositories.ProductRepository;
import com.devsuperior.workshopcassandra.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public ProductDTO findById(UUID id) {
        Product entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department not found"));

        return new ProductDTO(entity);
    }

    public List<ProductDTO> findAll() {
        List<Product> products = repository.findAll();

        return products.stream().map(ProductDTO::new).toList();
    }

    public List<ProductDTO> findByDepartment(String text) {
        List<Product> list;

        if ("".equals(text)) {
            list = repository.findAll();
        } else {
            list = repository.findByDepartment(text);
        }
        return list.stream().map(ProductDTO::new).toList();
    }

    public List<ProductDTO> findByDescription(String description) {
        List<Product> entity;

        if ("".equals(description)) {
            entity = repository.findAll();
        } else {
            entity = repository.findProductsByDescription(description);

        }
        return entity.stream().map(ProductDTO::new).toList();
    }
}
