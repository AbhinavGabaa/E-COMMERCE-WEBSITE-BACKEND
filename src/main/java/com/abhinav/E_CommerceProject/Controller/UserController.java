package com.abhinav.E_CommerceProject.Controller;

import com.abhinav.E_CommerceProject.DTO.request.AddCartReq;
import com.abhinav.E_CommerceProject.DTO.request.AddProductreq;
import com.abhinav.E_CommerceProject.DTO.request.BuyReq;
import com.abhinav.E_CommerceProject.DTO.request.RegisterUserReq;
import com.abhinav.E_CommerceProject.DTO.response.AddCartResponse;
import com.abhinav.E_CommerceProject.DTO.response.BuyResponse;
import com.abhinav.E_CommerceProject.DTO.response.RegisterUserResponse;
import com.abhinav.E_CommerceProject.Enum.ResponseStatus;
import com.abhinav.E_CommerceProject.Model.*;
import com.abhinav.E_CommerceProject.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

//@RequestMapping("/api")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String greet() {
        return "hello & Welcome";
    }

    @PostMapping("/api/register")
    public RegisterUserResponse registerUser(@RequestBody RegisterUserReq userReq) {
        RegisterUserResponse registerUserResponse = new RegisterUserResponse();
        User ans = userService.register(userReq);

        registerUserResponse.setId(ans.getId());
        registerUserResponse.setResponseStatus(ResponseStatus.PASS);
        registerUserResponse.setMessage("User Registered Successfully");
        return registerUserResponse;
    }


    @PostMapping("/api/login")
    public String login(@RequestBody User user) {
        // System.out.println(user);

        return userService.verify(user);
    }

    //    @PostMapping("/api/cart/add")
//    public Cart addCart(@RequestBody Cart cart) {
//        try {
//            return userService.addToCart(cart);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//    public ResponseEntity<Cart> addcart(@RequestBody Cart cart) {
//        try {
//            Cart Cart1 = userService.addTocart(cart);
//            return new ResponseEntity<>(Cart1, HttpStatus.CREATED);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return new ResponseEntity<>(cart, HttpStatus.INTERNAL_SERVER_ERROR);
//
//    }

    @GetMapping("/api/products")
    public List<Product> getAllProducts() {
        return userService.getAllProducts();
    }

    @GetMapping("/api/products/search")
    public List<Product> searchProduct(@RequestParam String keyword) {
        return userService.searchProduct(keyword);
    }

    @PostMapping("/api/cart/add")
    public AddCartResponse addCart(Authentication authentication,@RequestBody AddCartReq req) {

            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            String username = userDetails.getUsername();
            System.out.println(username);
            return userService.addCart(username, req);
        }
//        public BorrowBookResponse borrowBook(Authentication authentication, @RequestBody BorrowBookRequest request) {
//            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
//            String username = userDetails.getUsername();
//            return bookService.borrowBook(username, request);
//        }

//        if(Cartid != null){
//            //check in db,
//            if(//present in db,db seh jo entry udate it.)
//        }
//        else{
//            // new cart & save it.
//        }
    @GetMapping("/api/cart")
    public List<Cart> getAllCart() {
        return userService.getAllcart();
    }
    @PostMapping("/api/cart/buy")
    public BuyResponse buyProduct(@AuthenticationPrincipal Userprincipal userprincipal, @RequestBody BuyReq buyReq){
        return userService.buyProduct(buyReq,userprincipal.getUser());

    }

    @GetMapping("/api/orders")
    public List<Order> getOrders( @RequestParam int userid){
        return userService.getOrders(userid);
    }



}





