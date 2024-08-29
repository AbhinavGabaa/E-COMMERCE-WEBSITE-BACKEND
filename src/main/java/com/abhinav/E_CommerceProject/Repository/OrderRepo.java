package com.abhinav.E_CommerceProject.Repository;

import com.abhinav.E_CommerceProject.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepo extends JpaRepository<Order, Integer> {
    List<Order> findByUserId(int userid);
}
