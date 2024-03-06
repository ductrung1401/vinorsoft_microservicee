package com.trungtd.employeeservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AddEmployeeDepartment {
    private Long departmentId;
    private Long employeeId;
}
