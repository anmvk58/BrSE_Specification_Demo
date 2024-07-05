package com.anmv.mapper.repository;

import com.anmv.mapper.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDepartmentRepository extends JpaRepository<Department, Integer> {
    boolean existsByName(String name);
}
