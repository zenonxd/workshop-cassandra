package com.devsuperior.workshopcassandra.repositories;

import com.devsuperior.workshopcassandra.model.entities.Department;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.UUID;

public interface DepartmentRepository extends CassandraRepository<Department, UUID> {
    Department getById(UUID id);
}
