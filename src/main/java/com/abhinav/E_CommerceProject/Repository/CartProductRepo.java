package com.abhinav.E_CommerceProject.Repository;

import com.abhinav.E_CommerceProject.Model.CartProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartProductRepo extends JpaRepository<CartProduct, Integer> {
}
