package com.dxctechnology.reactapplication.service;

import com.dxctechnology.reactapplication.DTO.RouteDTO;
import com.dxctechnology.reactapplication.DTO.UserDTO;
import com.dxctechnology.reactapplication.entities.Role;
import com.dxctechnology.reactapplication.entities.Route;
import com.dxctechnology.reactapplication.exception.ResourceNotFoundException;
import com.dxctechnology.reactapplication.exception.UsernameAlreadyExistsException;
import com.dxctechnology.reactapplication.entities.User;
import com.dxctechnology.reactapplication.repository.RoleRepository;
import com.dxctechnology.reactapplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    public static final Long NORMAL_USER_ID =101L;
    public static final Long ADMIN_USER_ID =102L;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public  User saveUser(User newUser) {
        try{
            newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
            //Username has to be unique (exception)
            newUser.setUsername(newUser.getUsername());
            newUser.setConfirmPassword("");

            //set role for normal users;
            Role role = roleRepository.findById(NORMAL_USER_ID).get();
            newUser.getRoles().add(role);

            return userRepository.save(newUser);

        }catch (Exception e){
            throw new UsernameAlreadyExistsException("Username '"+newUser.getUsername()+"' already exists");
        }

    }

    public List<User> getUsers() {

        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).
                orElseThrow(()->new ResourceNotFoundException("User not found with id " + id));
    }


    public void deleteUser(User user) {

        userRepository.delete(user);
    }

    public User upadateUser(Long id, UserDTO userDTO) {
        User user = getUserById(id);
        user.setUsername(userDTO.getUsername());
        user.setFullName(userDTO.getFullName());
        user.setPassword(userDTO.getPassword());
        user.setConfirmPassword(userDTO.getConfirmPassword());
        System.out.println(user);
        return saveUser(user);

    }


}
