package com.example.usermanagmentservice.Service;

import com.example.usermanagmentservice.Models.users;
import com.example.usermanagmentservice.Repository.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class UserserviceImp implements Userservice
{
    UserRespository userRepository;

    public UserserviceImp(UserRespository userRepository)
    {

        this.userRepository = userRepository;
    }

    public void adduser(users u)
    {
        userRepository.save(u);
    }

    public users getuser(int id)
    {
        return userRepository.findById(id);
    }

}
