package com.abhinav.E_CommerceProject.Service;

import com.abhinav.E_CommerceProject.Model.User;
import com.abhinav.E_CommerceProject.Model.Userprincipal;
import com.abhinav.E_CommerceProject.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class TheUserDetails implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user =  userRepo.findByUsername(username);
        if(user == null){
            System.out.println("User Not found");
            throw new UsernameNotFoundException("user not found");
        }
        return new Userprincipal(user);
    }
}





