package com.trungtd.departmentservice.controller;

import com.trungtd.departmentservice.model.AddEmployeeDepartment;
import com.trungtd.departmentservice.model.Department;
import com.trungtd.departmentservice.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/department")
@RequiredArgsConstructor
public class DepartmentController {
    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);
    private final DepartmentService departmentService;

    @PostMapping("/add-department")
    public ResponseEntity<?> addDepartment(@RequestBody Department department) {
        LOGGER.info("Department add: {}", department);
        return ResponseEntity.ok(departmentService.addDepartment(department));
    }

    @GetMapping("")
    public ResponseEntity<?> getAllDepartment() {
        LOGGER.info("Department find");
        List<Department> departmentList = departmentService.getAllDepartment();
        return ResponseEntity.ok(departmentList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getDepartmentById(@PathVariable Long id) {
        LOGGER.info("Department find: id={}", id);
        return ResponseEntity.ok(departmentService.getDepartmentById(id));
    }

    @GetMapping("/with-employee/{departmentId}")
    public ResponseEntity<?> getDepartmentWithEmployees(@PathVariable Long departmentId) {
        return ResponseEntity.ok(departmentService.getDepartmentWithEmployees(departmentId));
    }

    @PostMapping("/add-employee")
    public ResponseEntity<?> addEmployee(@RequestBody AddEmployeeDepartment req) {
        return ResponseEntity.ok(departmentService.addEmployeeToDepartment(req));
    }
}
