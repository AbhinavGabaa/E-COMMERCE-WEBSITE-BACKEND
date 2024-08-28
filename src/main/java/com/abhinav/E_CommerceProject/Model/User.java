package com.abhinav.E_CommerceProject.Model;

import com.abhinav.E_CommerceProject.Enum.UserType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Enumerated(EnumType.STRING)
    private UserType usertype;

    private String username;
    private String email;
    private String password;

//    @OneToMany(mappedBy = "user")
//    private List<Cart> cart;

//    public UserType getUserType() {
//        return usertype;
//    }
//
//    public String getUsername() {
//        return username;
//    }
}
