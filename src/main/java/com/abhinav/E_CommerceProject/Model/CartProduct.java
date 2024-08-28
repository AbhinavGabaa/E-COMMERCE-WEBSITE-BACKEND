package com.abhinav.E_CommerceProject.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "cart_related_products")
public class CartProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Cart cart;

    @ManyToOne
    private Product product;


    private Integer quantity;
}
