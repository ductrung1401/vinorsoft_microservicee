package com.trungtd.departmentservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee {
    private Long id;
    private String name;
    private int age;
    private String position;
    private Long departmentId;
}
