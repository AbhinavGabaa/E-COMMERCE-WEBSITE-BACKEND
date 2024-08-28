package com.abhinav.E_CommerceProject.DTO.request;

import lombok.Data;

@Data
public class AddProductreq {


//    @ManyToOne
//    private Category category;
    private String name;
    private int price;
    private int stock;
}
