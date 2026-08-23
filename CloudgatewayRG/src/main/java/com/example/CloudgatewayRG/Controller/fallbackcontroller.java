package com.example.CloudgatewayRG.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class fallbackcontroller
{
    @GetMapping("/fallback")
    public String fallback()
    {
        return "Service is down";
    }
}
