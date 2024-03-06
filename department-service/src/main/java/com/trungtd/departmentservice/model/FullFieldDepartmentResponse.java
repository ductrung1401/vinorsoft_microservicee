package com.trungtd.departmentservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FullFieldDepartmentResponse {
    private String name;
    List<Employee> employeeList;
}
