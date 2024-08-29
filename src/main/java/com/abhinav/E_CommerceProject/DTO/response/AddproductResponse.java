package com.abhinav.E_CommerceProject.DTO.response;

import lombok.Data;

@Data
public class AddproductResponse extends BaseResponse{
    private int id;
    private String name;
    private int price;
    private int stock;
    private String categoryName;
}
