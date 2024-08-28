package com.abhinav.E_CommerceProject.DTO.request;

import com.abhinav.E_CommerceProject.Enum.UserType;
import lombok.Data;

@Data
public class RegisterUserReq {

        private String username;
        private String password;
        private String email;

        private UserType usertype;
    }


