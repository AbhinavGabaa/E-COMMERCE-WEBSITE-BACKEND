package com.abhinav.E_CommerceProject.Repository;

import com.abhinav.E_CommerceProject.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends JpaRepository<Order, Integer> {
}
