package com.abhinav.E_CommerceProject.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@Entity
public class Cart {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//
//    @OneToOne
//    private User user;
//


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JoinColumn(name = "userId")
    @OneToOne
    private User user;

    @JoinColumn(name = "productId")
    @OneToMany
    private List<Product> products;
}

