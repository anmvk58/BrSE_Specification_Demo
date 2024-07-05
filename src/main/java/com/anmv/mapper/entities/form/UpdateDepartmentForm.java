package com.anmv.mapper.entities.form;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UpdateDepartmentForm {
    private String name;

    private int totalMember;

    private String type;
}
