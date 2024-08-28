package com.abhinav.E_CommerceProject.Repository;

import com.abhinav.E_CommerceProject.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer> {
}
