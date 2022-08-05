package com.cadnunsdimir.myfinances.controllers;

import com.cadnunsdimir.myfinances.models.Transaction;
import com.cadnunsdimir.myfinances.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/bank/transaction")
public class TransactionController {
    @Autowired
    private TransactionRepository repository;

    @PostMapping
    public Transaction save(@RequestBody Transaction transaction) {
        return repository.save(transaction);
    }
}
