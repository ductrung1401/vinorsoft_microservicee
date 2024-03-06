package com.trungtd.departmentservice.service.implement;

import com.trungtd.departmentservice.client.EmployeeClient;
import com.trungtd.departmentservice.custom.exception.ExistsException;
import com.trungtd.departmentservice.model.AddEmployeeDepartment;
import com.trungtd.departmentservice.model.Department;
import com.trungtd.departmentservice.model.Employee;
import com.trungtd.departmentservice.model.FullFieldDepartmentResponse;
import com.trungtd.departmentservice.repository.DepartmentRepository;
import com.trungtd.departmentservice.response.MessageResponse;
import com.trungtd.departmentservice.service.DepartmentService;
import jakarta.ws.rs.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final EmployeeClient employeeClient;

    @Override
    public Department addDepartment(Department department) {
//        Optional<Department> departmentOptional = Optional.ofNullable(department);
//
//        departmentOptional.ifPresent(value -> departmentRepository.save(value));
//        return departmentOptional.get();
        Optional.ofNullable(department)
                .filter(dep -> !departmentRepository.existsById(dep.getId()))
                .orElseThrow(
                        () -> new ExistsException("Department cannot be null or already exists")
                );
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getAllDepartment() {
        List<Department> departments = departmentRepository.findAll();
        if (!departments.isEmpty())
            return departments;
        else
            throw new NotFoundException("Khong ton tai phong ban nao trong he thong");
    }

    @Override
    public Department getDepartmentById(Long id) {
        return departmentRepository.findById(id).orElseThrow(
                () -> new com.trungtd.departmentservice.custom.exception.NotFoundException("Khong ton tai phong ban voi id=" + id)
        );
    }

    @Override
    public FullFieldDepartmentResponse getDepartmentWithEmployees(Long departmentId) {
        Department department = this.getDepartmentById(departmentId);
        List<Employee> employees = employeeClient.getEmployeesByDepartment(departmentId);
        return FullFieldDepartmentResponse.builder()
                .name(department.getName())
                .employeeList(employees)
                .build();
    }

    @Override
    public MessageResponse addEmployeeToDepartment(AddEmployeeDepartment req) {
        Department department = this.getDepartmentById(req.getDepartmentId());
        MessageResponse response = employeeClient.addEmployeeToDepart(req);
        return response;
    }
}
