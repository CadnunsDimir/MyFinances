package com.cadnunsdimir.myfinances.controllers;

import com.cadnunsdimir.myfinances.models.BankAccount;
import com.cadnunsdimir.myfinances.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/bank/account")
public class BankAccountController {

    @Autowired
    private BankAccountRepository repository;

    @GetMapping()
    public List<BankAccount> list() {
        List<BankAccount> list = new ArrayList<>();
        repository.findAll().forEach(list::add);
        return list;
    }

    @GetMapping("/{id}")
    public ResponseEntity<BankAccount> get(@PathVariable("id") int id) {
        return repository.findById(id)
                .map(x-> ResponseEntity.ok().body(x))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public BankAccount create(@RequestBody BankAccount bankAccount) {
        return repository.save(bankAccount);
    }
}
