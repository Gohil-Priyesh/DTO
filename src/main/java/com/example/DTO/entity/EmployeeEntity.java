package com.example.DTO.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employee")
@Builder
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private String email;

    private String contact;

    /// The foreign key is ALWAYS on the “many” side.
    @ManyToOne
    @JoinColumn(name = "department_id")
    private DepartmentEntity department;
}
