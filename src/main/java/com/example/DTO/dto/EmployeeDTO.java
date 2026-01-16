package com.example.DTO.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeDTO {

    private String name;

    private String email;

    private String contact;

    private DepartmentDTO department;
}
