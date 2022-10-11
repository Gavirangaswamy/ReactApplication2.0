package com.dxctechnology.reactapplication.controller;

import com.dxctechnology.reactapplication.DTO.UserDTO;
import com.dxctechnology.reactapplication.entities.Route;
import com.dxctechnology.reactapplication.entities.User;
import com.dxctechnology.reactapplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    ;
    @Autowired
    UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> addUser(@Valid @RequestBody User user) {
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/allusers")
    public List<User> getAllUser(){
        return userService.getUsers();
    }

    @GetMapping("/getUser/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id){
        User user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/updateUser/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @Valid @RequestBody UserDTO userDto) {
        User user = userService.upadateUser(id,userDto);
        return ResponseEntity.ok(user);
    }

    @PreAuthorize(("hasRole('ADMIN')"))
    @DeleteMapping("/deleteUser/{id}")
    public void deleteUser(User user) {
        userService.deleteUser(user);
    }
}
