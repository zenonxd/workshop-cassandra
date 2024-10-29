package com.devsuperior.workshopcassandra.controllers;

import com.devsuperior.workshopcassandra.model.dtos.DepartmentDTO;
import com.devsuperior.workshopcassandra.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping
    public ResponseEntity<List<DepartmentDTO>> findAll() {
        List<DepartmentDTO> dto = departmentService.findAll();
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<DepartmentDTO> findById(@PathVariable UUID id) {
        DepartmentDTO dto = departmentService.findById(id);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public ResponseEntity<DepartmentDTO> insert(@RequestBody DepartmentDTO dto) {
        dto = departmentService.insert(dto);

        URI uri = URI.create("/departments/" + dto.getId());
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<DepartmentDTO> update(@PathVariable UUID id, @RequestBody DepartmentDTO dto) {
        dto = departmentService.update(id, dto);
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<DepartmentDTO> delete(@PathVariable UUID id) {
        departmentService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
