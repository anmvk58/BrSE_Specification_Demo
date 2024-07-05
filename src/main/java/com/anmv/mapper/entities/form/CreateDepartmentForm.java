package com.anmv.mapper.entities.form;

import com.anmv.mapper.validation.DepartmentNameExists;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateDepartmentForm {
    @NotBlank(message = "Không được phép để trống tên")
    @DepartmentNameExists
    private String name;

    @NotNull(message = "Không được phép để trống sĩ số")
    @PositiveOrZero(message = "Sĩ số không được nhỏ hơn 0")
    private int totalMember;

    private String type;
}
