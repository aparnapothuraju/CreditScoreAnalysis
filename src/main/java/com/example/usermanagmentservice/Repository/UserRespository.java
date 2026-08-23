package com.example.usermanagmentservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.usermanagmentservice.Models.users;


@Repository
public interface UserRespository extends JpaRepository<users, Integer>
{

    users findById(int user_ID);
    users save(users users);
}
