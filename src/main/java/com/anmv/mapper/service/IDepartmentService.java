package com.anmv.mapper.service;

import com.anmv.mapper.entities.form.CreateDepartmentForm;
import com.anmv.mapper.entities.form.UpdateDepartmentForm;

public interface IDepartmentService {
    void createDepartment(CreateDepartmentForm form);

    void updateDepartment(UpdateDepartmentForm form, int inputId);

    boolean isDepartmentExistsByName(String name);
}
