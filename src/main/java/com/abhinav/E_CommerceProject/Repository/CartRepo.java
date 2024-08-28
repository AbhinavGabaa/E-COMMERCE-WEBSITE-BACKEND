package com.abhinav.E_CommerceProject.Repository;

import com.abhinav.E_CommerceProject.Model.Cart;
import com.abhinav.E_CommerceProject.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartRepo extends JpaRepository<Cart,Integer> {

    Optional<Cart> findByUser(User user);
}
