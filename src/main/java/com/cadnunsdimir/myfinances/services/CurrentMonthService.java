package com.cadnunsdimir.myfinances.services;

import com.cadnunsdimir.myfinances.models.BankAccount;
import com.cadnunsdimir.myfinances.models.MonthTransactions;
import com.cadnunsdimir.myfinances.models.Transaction;
import com.cadnunsdimir.myfinances.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Comparator;
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

        int year = firstDay.get(Calendar.YEAR);
        int currentMonth = firstDay.get(Calendar.MONTH);
        int nextMonth = currentMonth + 1;

        firstDay.set(year,currentMonth,0);

        Calendar lastDay = Calendar.getInstance();
        lastDay.set(year,nextMonth,0);

        System.out.println(firstDay);
        System.out.println(lastDay);

        month.setYear(Calendar.getInstance().get(Calendar.YEAR));
        month.setMonth(Calendar.getInstance().get(Calendar.MONTH)+1);

        List<Transaction> monthTransactions = this.transactions.findByDateBetween(firstDay.getTime(), lastDay.getTime());
        monthTransactions.sort(Comparator.comparing(Transaction::getDate));
        month.setTransactions(monthTransactions);

        return month;
    }
}
