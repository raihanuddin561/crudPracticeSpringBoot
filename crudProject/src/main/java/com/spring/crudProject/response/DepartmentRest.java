package com.spring.crudProject.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DepartmentRest {
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;
}
