package com.devsuperior.workshopcassandra.services;

import com.devsuperior.workshopcassandra.model.dtos.DepartmentDTO;
import com.devsuperior.workshopcassandra.model.entities.Department;
import com.devsuperior.workshopcassandra.repositories.DepartmentRepository;
import com.devsuperior.workshopcassandra.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public DepartmentDTO findById(UUID id) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department not found"));

        return new DepartmentDTO(department);
    }

    public DepartmentDTO insert(DepartmentDTO dto) {
        Department department = new Department();

        department.setId(UUID.randomUUID());
        department.setName(dto.getName());

        departmentRepository.save(department);
        return new DepartmentDTO(department);
    }

    public List<DepartmentDTO> findAll() {
        List<Department> departments = departmentRepository.findAll();

        return departments.stream().map(DepartmentDTO::new).toList();
    }

    public DepartmentDTO update(UUID id, DepartmentDTO dto) {
        Department entity = departmentRepository.getById(id);
        entity.setName(dto.getName());
        departmentRepository.save(entity);
        return new DepartmentDTO(entity);
    }

    public void delete(UUID id) {
        if (!departmentRepository.existsById(id)) {
            throw new ResourceNotFoundException("Department not found");
        }
        departmentRepository.deleteById(id);
    }
}
