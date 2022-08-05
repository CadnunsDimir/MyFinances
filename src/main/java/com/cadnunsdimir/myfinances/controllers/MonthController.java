package com.cadnunsdimir.myfinances.controllers;

import com.cadnunsdimir.myfinances.models.BankAccount;
import com.cadnunsdimir.myfinances.models.MonthTransactions;
import com.cadnunsdimir.myfinances.services.CurrentMonthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/bank/month")
public class MonthController {

    @Autowired
    private CurrentMonthService service;

    @GetMapping()
    public MonthTransactions get() {
        List<BankAccount> accounts = Arrays.asList(new BankAccount());
        return service.getMonth(accounts);
    }
}
