package com.example.DTO.service.impl;

import com.example.DTO.dto.UserDTO;
import com.example.DTO.mapper.UserMapper;
import com.example.DTO.repository.UserRepository;
import com.example.DTO.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/// service talks with Repository
@Service
public class UserServiceImpl implements UsersService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserMapper userMapper;

    /// if I am using optional in repository then I have to map the dto to the optional<UserEntity>
    @Override
    public UserDTO findUserById(Integer id){
        return userRepository.findById(id)
                .map(userMapper::toDTO)
                .orElse(new UserDTO());
    }
}
