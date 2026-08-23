package com.example.usermanagmentservice.Service;

import com.example.usermanagmentservice.Models.users;

public interface Userservice
{
    public void adduser(users user);
    public users getuser(int id);


}
