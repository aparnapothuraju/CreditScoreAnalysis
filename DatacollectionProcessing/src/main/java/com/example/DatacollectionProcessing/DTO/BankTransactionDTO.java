package com.example.DatacollectionProcessing.DTO;

import lombok.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class BankTransactionDTO
{
    public int user_id;
    public LocalDateTime transaction_date;
    public BigDecimal amount;
    public String transaction_type;
    public String category;
    public BigInteger balance_after;
}
