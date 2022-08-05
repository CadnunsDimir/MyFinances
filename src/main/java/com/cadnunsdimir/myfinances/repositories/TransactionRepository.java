package com.cadnunsdimir.myfinances.repositories;

import com.cadnunsdimir.myfinances.models.Transaction;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface TransactionRepository extends CrudRepository<Transaction, Integer> {
    List<Transaction> findByDateBetween(Date firstDayTime, Date lastDayTime);
}
