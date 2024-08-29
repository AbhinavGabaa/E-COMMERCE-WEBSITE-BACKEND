package com.abhinav.E_CommerceProject.DTO.request;

import com.abhinav.E_CommerceProject.Model.Category;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class AddProductreq {


    //    @ManyToOne
//    private Category category;
    private String name;
    private int price;
    private int stock;
    private int categoryId;
    // ID of the category to associate with the product

}
