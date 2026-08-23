package com.example.usermanagmentservice.Controller;

import com.example.usermanagmentservice.DTO.UserDTO;
import com.example.usermanagmentservice.Models.users;
import com.example.usermanagmentservice.Service.Userservice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController
{
    Userservice userservice;

    public UserController(Userservice userservice)
    {
        this.userservice = userservice;
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<UserDTO> getuser(@PathVariable int id)
    {


        users user=userservice.getuser(id);

        UserDTO userDTO = new UserDTO().builder().username(user.getFull_name()).email(user.getEmail()).phoneNumber(user.getPhone()).city(user.getAddress_city()).build();

        return new ResponseEntity<>(userDTO,HttpStatus.OK);
    }

    @PutMapping("/user")
    public ResponseEntity<Void> addUser(@RequestBody UserDTO userDTO)
    {
        users u=new users().builder().full_name(userDTO.getUsername()).email(userDTO.getEmail()).phone(userDTO.getPhoneNumber()).address_city(userDTO.getCity()).build();
        userservice.adduser(u);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
