package com.anmv.mapper.entities.form;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateAccountForm {
    private String username;

    private int departmentId;
}
