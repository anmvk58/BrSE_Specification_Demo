package com.anmv.mapper.service;

import com.anmv.mapper.entities.Department;
import com.anmv.mapper.entities.form.CreateDepartmentForm;
import com.anmv.mapper.entities.form.UpdateDepartmentForm;
import com.anmv.mapper.repository.IDepartmentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService implements IDepartmentService{
    @Autowired
    private IDepartmentRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void createDepartment(CreateDepartmentForm form) {
        // buoc 1 => convert Form -> Department
        Department department = modelMapper.map(form, Department.class);
        // buoc 2 => goi jpa function de create
        repository.save(department);
    }

    @Override
    public void updateDepartment(UpdateDepartmentForm form, int inputId) {
        // buoc 1 => convert Form -> Department
        Department department = modelMapper.map(form, Department.class);
        department.setId(inputId);
        // buoc 2 => goi jpa function de update
        repository.save(department);
    }

    @Override
    public boolean isDepartmentExistsByName(String name) {
        return repository.existsByName(name);
    }
}
