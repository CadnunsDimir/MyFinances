package com.cadnunsdimir.myfinances.repositories;

import com.cadnunsdimir.myfinances.models.BankAccount;
import com.cadnunsdimir.myfinances.models.Transaction;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public interface TransactionRepository extends CrudRepository<Transaction, Integer> {
    List<Transaction> findByDateBetween(Date firstDayTime, Date lastDayTime);
    default List<Transaction> list() {
        List<Transaction> list = new ArrayList<>();
        findAll().forEach(list::add);
        return list;
    }
}
