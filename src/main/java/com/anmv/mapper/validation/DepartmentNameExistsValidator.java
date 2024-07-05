package com.anmv.mapper.validation;

import com.anmv.mapper.service.IDepartmentService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class DepartmentNameExistsValidator implements ConstraintValidator<DepartmentNameExists, String> {
    @Autowired
    private IDepartmentService service;

    @Override
    public boolean isValid(String name, ConstraintValidatorContext constraintValidatorContext) {
        return !service.isDepartmentExistsByName(name);
    }
}
