package com.example.usermanagmentservice.DTO;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO
{
    String username;
    String email;
    String phoneNumber;
    String city;
}
