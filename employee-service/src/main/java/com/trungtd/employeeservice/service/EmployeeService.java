package com.trungtd.employeeservice.service;

import com.trungtd.employeeservice.custom.exception.ExistsException;
import com.trungtd.employeeservice.custom.response.MessageResponse;
import com.trungtd.employeeservice.model.AddEmployeeDepartment;
import com.trungtd.employeeservice.model.Employee;
import com.trungtd.employeeservice.repository.EmployeeRepository;
import jakarta.ws.rs.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public Employee addEmployee(Employee employee) {
        Optional.ofNullable(employee)
                .filter(em -> !employeeRepository.existsById(em.getId()))
                .orElseThrow(
                        () -> new ExistsException("Employee cannot be null or already exists")
                );
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployee() {
        List<Employee> employees = employeeRepository.findAll();
        if (employees.isEmpty())
            throw new NotFoundException("Khong ton tai employee nao trong he thong");
        return employees;
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElseThrow(
                () -> new com.trungtd.employeeservice.custom.exception.NotFoundException("Khong ton tai employee voi id=" + id)
        );
    }

    public List<Employee> getEmployeesByDepartment(Long departmentId) {
        List<Employee> employees = employeeRepository.findByDepartmentId(departmentId);
        if (employees.isEmpty())
            throw new NotFoundException("Khong ton tai employee nao voi department_id=" + departmentId + " trong he thong");
        return employees;
    }

    public MessageResponse addEmployeeToDepart(AddEmployeeDepartment req) {

        return employeeRepository.findById(req.getEmployeeId())
                .map(employee -> {
                    employee.setDepartmentId(req.getDepartmentId());
                    employeeRepository.save(employee);
                    return MessageResponse.builder()
                            .message("SUCCESS")
                            .build();
                })
                .orElse(MessageResponse.builder()
                        .message("Employee is not exist")
                        .build());
    }
}
