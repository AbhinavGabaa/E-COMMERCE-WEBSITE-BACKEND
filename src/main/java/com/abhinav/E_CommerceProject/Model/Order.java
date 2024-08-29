package com.abhinav.E_CommerceProject.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    private Cart cart;

    @ManyToOne
    private User user;

    private int amount;


}
