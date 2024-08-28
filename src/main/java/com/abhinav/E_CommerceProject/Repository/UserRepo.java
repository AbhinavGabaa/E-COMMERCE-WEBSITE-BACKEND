package com.abhinav.E_CommerceProject.Repository;

import com.abhinav.E_CommerceProject.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {
    User findByUsername(String username);

    //   User findByUsername(String username);
}
