package com.example.DatacollectionProcessing.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BankTransaction
{
    private int user_id;
    private LocalDateTime transaction_date;
    private BigDecimal amount;
    private String transaction_type;
    private String category;
    private BigInteger balance_after;
}
