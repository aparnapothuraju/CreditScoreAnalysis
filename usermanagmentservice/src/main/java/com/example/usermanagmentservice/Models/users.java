package com.example.usermanagmentservice.Models;

import jakarta.persistence.*;
import lombok.*;
import org.joda.time.DateTime;
import java.time.LocalDateTime;


import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class users
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int user_ID;
    @Column(name="full_name")
    String full_name;
    @Column(name="email")
    String email;
    @Column(name="phone")
    String phone;
    @Column(name="date_of_birth")
    Date date_of_birth;
    @Column(name="address_city")
    String address_city;
    @Column(name="address_country")
    String address_country;
    @Column(name="account_status")
    String account_status;
    @Column(name="created_at")
    LocalDateTime created_at;

}
