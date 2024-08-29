package com.abhinav.E_CommerceProject.Controller;

import com.abhinav.E_CommerceProject.DTO.request.AddProductreq;
import com.abhinav.E_CommerceProject.DTO.response.AddproductResponse;
import com.abhinav.E_CommerceProject.Enum.ResponseStatus;
import com.abhinav.E_CommerceProject.Enum.UserType;
import com.abhinav.E_CommerceProject.Model.Product;
import com.abhinav.E_CommerceProject.Model.Userprincipal;
import com.abhinav.E_CommerceProject.Repository.ProductRepo;
import com.abhinav.E_CommerceProject.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class AdminController {
    @Autowired
    private UserService userService;


//    @PostMapping("/api/product/add")
//    public AddproductResponse addProduct(@AuthenticationPrincipal Userprincipal userPrincipal, @RequestBody AddProductreq addProductreq){
//        AddproductResponse response = new AddproductResponse();
//
//        if (userPrincipal == null) {
//            response.setResponseStatus(ResponseStatus.FAILED);
//            response.setMessage("User not authenticated.");
//            return response;
//        }
//
//        if (userPrincipal.getUserType() != UserType.ADMIN) {
//            System.out.println(userPrincipal.getUserType());
//            response.setResponseStatus(ResponseStatus.FAILED);
//            response.setMessage("You are not authorized to perform this action.");
//            System.out.println(userPrincipal.getUserType());
//            return response;
//        }
//        try {
//           // Product productsave = new Product();
//            Product  productsave = userService.addAProduct(addProductreq);
//
//            response.setId(productsave.getId());
//            response.setResponseStatus(ResponseStatus.PASS);
//            response.setMessage("Product added successfully.");
//        }catch (Exception e){
//            e.printStackTrace();
//            response.setResponseStatus(ResponseStatus.FAILED);
//            response.setMessage("Failed to add product.");
//        }
//        return response;
//    }
    @PostMapping("/api/product/add")
    public ResponseEntity<Product> addProduct(@RequestBody AddProductreq addProductreq) {
        Product product = userService.addAProduct(addProductreq);
        return ResponseEntity.ok(product);
    }


}
