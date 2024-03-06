package com.trungtd.employeeservice.controller;

import com.trungtd.employeeservice.model.AddEmployeeDepartment;
import com.trungtd.employeeservice.model.Employee;
import com.trungtd.employeeservice.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @PostMapping("/add-employee")
    public ResponseEntity<?> addEmployee(@RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.addEmployee(employee));
    }

    @GetMapping("")
    public ResponseEntity<?> getEmployee() {
        List<Employee> employeeList = employeeService.getAllEmployee();
        return ResponseEntity.ok(employeeList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable Long id) {
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }

    @GetMapping("/department/{departmentId}")
    public ResponseEntity<?> getEmployeesByDepartment(@PathVariable Long departmentId) {
        return ResponseEntity.ok(employeeService.getEmployeesByDepartment(departmentId));
    }

    @PostMapping("/add-to-department")
    public ResponseEntity<?> addEmployeeToDepart(@RequestBody AddEmployeeDepartment req) {
        return ResponseEntity.ok(employeeService.addEmployeeToDepart(req));
    }
}