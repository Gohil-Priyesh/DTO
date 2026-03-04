package com.example.DTO.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "orders")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "order_id")
    private Integer orderId;

    @Column(name = "order_date")
    private LocalDateTime orderDateTime;

    @Column(name = "order_quantity")
    private Integer orderQuantity;

    @Column(name = "total_amoung")
    private Float totalAmount;

    ///  The foreign key is ALWAYS on the “many” side.
    @ManyToOne
    @JoinColumn(name = "user_id") // This creates the foreign key column in the 'orders' table
    private UserEntity user;     // Changed from List<Integer> to the Entity type

}
