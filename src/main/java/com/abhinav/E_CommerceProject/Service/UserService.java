package com.abhinav.E_CommerceProject.Service;

import com.abhinav.E_CommerceProject.DTO.request.AddCartReq;
import com.abhinav.E_CommerceProject.DTO.request.AddProductreq;
import com.abhinav.E_CommerceProject.DTO.request.BuyReq;
import com.abhinav.E_CommerceProject.DTO.request.RegisterUserReq;
import com.abhinav.E_CommerceProject.DTO.response.AddCartResponse;
import com.abhinav.E_CommerceProject.DTO.response.BuyResponse;
import com.abhinav.E_CommerceProject.Enum.ResponseStatus;
import com.abhinav.E_CommerceProject.Model.*;
import com.abhinav.E_CommerceProject.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {


    @Autowired
    private UserRepo repo;

    @Autowired
    private CartRepo cartRepo;
    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private CategoryRepo categoryRepo;
    @Autowired
    private JWTService jwtService;

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    AuthenticationManager authenticationManager;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);


    public User register(RegisterUserReq req) {
        User useer = new User();
        useer.setUsername(req.getUsername());
        useer.setPassword(encoder.encode(req.getPassword()));
        useer.setEmail(req.getEmail());
        useer.setUsertype(req.getUsertype());

        return repo.save(useer);
    }

    public String verify(User user) {
        Authentication authentication =
                authenticationManager
                        .authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        if (authentication.isAuthenticated()) {
            String s = jwtService.generateToken(user.getUsername());
            return s;
        }

        return "Failed";
    }


    public Cart addTocart(Cart cart) {
        return cartRepo.save(cart);
    }

//    public Product addAProduct(AddProductreq addProductreq) {
//        Product product1 = new Product();
//        product1.setName(addProductreq.getName());
//        product1.setPrice(addProductreq.getPrice());
//        product1.setStock(addProductreq.getStock());
//        System.out.println(product1.getName());
//        return productRepo.save(product1);
//    }
public Product addAProduct(AddProductreq addProductreq) {
    Category category = categoryRepo.findById(addProductreq.getCategoryId())
            .orElseThrow(() -> new RuntimeException("Category not found"));

    Product product = new Product();
    product.setName(addProductreq.getName());
    product.setPrice(addProductreq.getPrice());
    product.setStock(addProductreq.getStock());
    product.setCategory(category);

    return productRepo.save(product);
}
    public Category addCategory(Category category) {
        return categoryRepo.save(category);
    }
    public List<Product> getProductsByCategory(int categoryId) {
        Category category = categoryRepo.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        return category.getProducts();
    }

    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    public List<Product> searchProduct(String keyword) {
        return productRepo.findByName(keyword);

    }


    public AddCartResponse addCart(String username, AddCartReq req) {

        AddCartResponse response = new AddCartResponse();

        try {
            Product product = productRepo.findById(req.getProductId())
                    .orElseThrow(() -> new RuntimeException("Product not found"));

            if (product.getStock() <= 0) {
                response.setMessage("Product is not available");
                return response;
            }

            User user = repo.findByUsername(username);

            // Reduce the stock by 1
            product.setStock(product.getStock() - 1);
            productRepo.save(product);

            Optional<Cart> cart = cartRepo.findById(req.getCartId());
            Cart cartHistory;

            if(cart.isPresent()){
                cartHistory = cart.get();
            }
            else {
                cartHistory = new Cart();
            }
            // Create a new Cart object
            cartHistory.setUser(user);

            // Create a List and add the Product to it
            List<Product> products = cartHistory.getProducts();
            if(products == null){
                products = new ArrayList<>();
            }
            products.add(product);

            // Set the products list in the Cart
            cartHistory.setProducts(products);

            response.setResponseStatus(ResponseStatus.PASS);
            response.setMessage("Product added to the cart successfully");

            // Save the cart history
            cartRepo.save(cartHistory);

        } catch (Exception e) {
            response.setMessage(e.getMessage());
        }

        return response;
    }


    public List<Cart> getAllcart() {
        return cartRepo.findAll();
    }
    public BuyResponse buyProduct( String username,BuyReq req){
        Optional<Cart> cart= cartRepo.findById(req.getCartId());
        Order order = new Order();
        order.setCart(cart.get());
        int amountTotal = 0;
        for(Product product : cart.get().getProducts())
        {
            amountTotal += product.getPrice();
        }
        order.setAmount(amountTotal);
        User user = repo.findByUsername(username);


        order.setUser(user);
        orderRepo.save(order);
        BuyResponse response = new BuyResponse();
        response.setTotalAmount(order.getAmount());
        response.setProducts(cart.get().getProducts());
        response.setMessage("Success");
        return response;
    }

    public List<Order> getOrders(int userid) {
        return orderRepo.findByUserId(userid);
    }
}
