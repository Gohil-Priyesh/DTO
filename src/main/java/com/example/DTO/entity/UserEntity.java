package com.example.DTO.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.query.Order;

import java.util.List;

@Entity
@Table(name = "user")
@Data
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "user_age")
    private Integer userAge;

    @Column(name = "user_contact")
    private Integer userContact;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<OrderEntity> orders; // This allows you to do user.getOrders()
}
