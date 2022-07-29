package com.cadnunsdimir.myfinances.repositories;

import com.cadnunsdimir.myfinances.models.BankAccount;
import org.springframework.data.repository.CrudRepository;

public interface BankAccountRepository extends CrudRepository<BankAccount, Integer> {
}
