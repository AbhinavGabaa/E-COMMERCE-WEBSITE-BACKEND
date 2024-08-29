package com.abhinav.E_CommerceProject.DTO.response;

import com.abhinav.E_CommerceProject.Model.Product;
import lombok.Data;

import java.util.List;

@Data
public class BuyResponse {
    List<Product> products;
    int totalAmount;
    String message;
}
