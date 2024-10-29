package com.devsuperior.workshopcassandra.model.dtos;

import com.devsuperior.workshopcassandra.model.entities.Department;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DepartmentDTO {

    private UUID id;
    private String name;

    public DepartmentDTO(Department department) {
        this.id = department.getId();
        this.name = department.getName();
    }

}
