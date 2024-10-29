package com.devsuperior.workshopcassandra.controllers;

import com.devsuperior.workshopcassandra.model.dtos.DepartmentDTO;
import com.devsuperior.workshopcassandra.model.dtos.ProductDTO;
import com.devsuperior.workshopcassandra.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductDTO>> findAll() {
        List<ProductDTO> dto = productService.findAll();
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProductDTO> findById(@PathVariable UUID id) {
        ProductDTO dto = productService.findById(id);
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping(params = "department")
    public ResponseEntity<List<ProductDTO>> findByDepartment(
            @RequestParam(name = "department", defaultValue = "") String description) {

        if (description != null) {
            List<ProductDTO> dto = productService.findByDepartment(description);
            return ResponseEntity.ok().body(dto);
        } else {
            List<ProductDTO> dto = productService.findAll();
            return ResponseEntity.ok().body(dto);
        }

    }

    @GetMapping(value = "/description")
    public ResponseEntity<List<ProductDTO>> findByDescription(
            @RequestParam(name = "description", defaultValue = "") String description) {
        
        if (description != null) {
            List<ProductDTO> dto = productService.findByDescription(description);
            return ResponseEntity.ok().body(dto);

        } else {
            List<ProductDTO> dto = productService.findAll();
            return ResponseEntity.ok().body(dto);
        }
    }
}
