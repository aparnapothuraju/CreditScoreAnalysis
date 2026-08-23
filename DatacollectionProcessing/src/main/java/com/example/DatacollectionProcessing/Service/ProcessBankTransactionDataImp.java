package com.example.DatacollectionProcessing.Service;

import com.example.DatacollectionProcessing.DTO.BankTransaction;
import com.example.DatacollectionProcessing.DTO.BankTransactionDTO;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;
@Service
public class ProcessBankTransactionDataImp implements ProcessBankTransactionData
{
    public BigDecimal averageMonthlyIncome(List<BankTransactionDTO> banklist, int userid)
    {
        List<BigDecimal> list= banklist.stream().filter(obj-> obj.getUser_id()==userid
                && obj.getCategory().equals("salary")).map(obj->obj.getAmount()).toList();

        if(list.size()!=0)
        {
            BigDecimal sum = list.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
            return sum.divide(new BigDecimal(list.size()));
        }

        return BigDecimal.ZERO;

    }
    public BigDecimal averageMonthlyExpenses(List<BankTransactionDTO> banklist,int userid)
    {
        List<BigDecimal> list= banklist.stream().filter(obj-> obj.getUser_id()==userid
                && obj.transaction_type.equals("DEBIT")).map(obj->obj.getAmount()).toList();

        if(list.size()!=0)
        {
            BigDecimal sum = list.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
            return sum.divide(new BigDecimal(list.size()));
        }

        return BigDecimal.ZERO;
    }
    public BigDecimal currentBalance(List<BankTransactionDTO> banklist,int userid)
    {
        LocalDateTime latestDate = banklist.stream()
                .map(BankTransactionDTO::getTransaction_date)
                .max(LocalDateTime::compareTo)
                .orElse(null);

        if(latestDate==null)
            return BigDecimal.ZERO;

        return banklist.stream().filter(s->s.equals(latestDate)).map(BankTransactionDTO::getAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
    }
    public int monthsOfNegativeBalance(List<BankTransactionDTO> banklist,int userid)
    {
        return 0;
    }
    public int totalLoanPaymentsMade(List<BankTransactionDTO> banklist,int userid)
    {
        return (int)banklist.stream().filter(s->s.getUser_id()==userid && s.getCategory().
                equals("LOAN_PAYMENT")).
                map(BankTransactionDTO::getAmount).count();
    }
}
