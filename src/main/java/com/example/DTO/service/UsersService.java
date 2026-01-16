package com.example.DTO.service;

import com.example.DTO.dto.UserDTO;
import org.springframework.stereotype.Service;


public interface UsersService {

    UserDTO findUserById(Integer id);

}
