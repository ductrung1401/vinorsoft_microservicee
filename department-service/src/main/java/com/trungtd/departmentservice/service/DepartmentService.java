package com.trungtd.departmentservice.service;

import com.trungtd.departmentservice.model.AddEmployeeDepartment;
import com.trungtd.departmentservice.model.Department;
import com.trungtd.departmentservice.model.FullFieldDepartmentResponse;
import com.trungtd.departmentservice.response.MessageResponse;

import java.util.List;

public interface DepartmentService {
    Department addDepartment(Department department);
    List<Department> getAllDepartment();
    Department getDepartmentById(Long id);
    FullFieldDepartmentResponse getDepartmentWithEmployees(Long departmentId);
    MessageResponse addEmployeeToDepartment(AddEmployeeDepartment req);

    //0021000429042
}
