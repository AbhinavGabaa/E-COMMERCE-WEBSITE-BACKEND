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

    @OneToMany
    private List<Cart> cartProductlist;

    @ManyToOne
    private User user;


}
