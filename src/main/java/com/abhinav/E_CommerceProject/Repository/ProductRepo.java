package com.abhinav.E_CommerceProject.Repository;

import com.abhinav.E_CommerceProject.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo  extends JpaRepository<Product, Integer> {
    List<Product> findByName(String name);

}
