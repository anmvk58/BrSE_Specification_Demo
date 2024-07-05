package com.anmv.mapper.controller;

import com.anmv.mapper.entities.form.CreateDepartmentForm;
import com.anmv.mapper.entities.form.UpdateDepartmentForm;
import com.anmv.mapper.service.IDepartmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/departments")
@Validated
public class DepartmentController {
    @Autowired
    private IDepartmentService service;

    @PostMapping
    public void createDepartment(@RequestBody @Valid CreateDepartmentForm form){
        service.createDepartment(form);
    }

    @PutMapping(value = "/{id}")
    public void updateDepartment(@RequestBody UpdateDepartmentForm form, @PathVariable(name = "id") int id){
        service.updateDepartment(form, id);
    }
}
