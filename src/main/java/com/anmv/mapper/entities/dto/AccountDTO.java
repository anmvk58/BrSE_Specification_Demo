package com.anmv.mapper.entities.dto;

import com.anmv.mapper.entities.Type;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class AccountDTO {
    @NonNull
    private int id;

    @NonNull
    private String username;

    @NonNull
    private String departmentName;

    private Type departmentType;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @JsonProperty("create_date")
    private Date departmentCreateDate;
}
