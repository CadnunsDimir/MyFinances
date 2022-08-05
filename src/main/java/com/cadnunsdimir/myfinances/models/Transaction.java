package com.cadnunsdimir.myfinances.models;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "bank_transaction")
public class Transaction {

    @Id
    @GeneratedValue
    private Integer id = 0;

    @Column
    private String description;

    @Column
    private Double value;

    @Transient
    private BankAccount account;
    private Date date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public BankAccount getAccount() {
        return account;
    }

    public void setAccount(BankAccount account) {
        this.account = account;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
