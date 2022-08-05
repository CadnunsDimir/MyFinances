package com.cadnunsdimir.myfinances.services;

import com.cadnunsdimir.myfinances.models.BankAccount;
import com.cadnunsdimir.myfinances.models.MonthTransactions;
import com.cadnunsdimir.myfinances.models.Transaction;
import com.cadnunsdimir.myfinances.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

@Service
public class CurrentMonthService {

    private final TransactionRepository transactions;

    @Autowired
    public CurrentMonthService(TransactionRepository transactions) {
        this.transactions = transactions;
    }
    public MonthTransactions getMonth(List<BankAccount> accounts) {
        List<String> accountNames = accounts.stream().map(BankAccount::getName).toList();
        MonthTransactions month = new MonthTransactions();
        Calendar firstDay = Calendar.getInstance();
        firstDay.set(Calendar.DAY_OF_MONTH,1);

        Calendar lastDay = Calendar.getInstance();
        lastDay.set(Calendar.DAY_OF_MONTH,31);

        month.setYear(Calendar.getInstance().get(Calendar.YEAR));
        month.setMonth(Calendar.getInstance().get(Calendar.MONTH));

        List<Transaction> monthTransactions = this.transactions.findByDateBetween(firstDay.getTime(), lastDay.getTime());

        month.setTransactions(monthTransactions);

        return month;
    }
}
