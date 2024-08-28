package com.abhinav.E_CommerceProject.Repository;

import com.abhinav.E_CommerceProject.Model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepo extends JpaRepository<Bill, Integer> {

}
