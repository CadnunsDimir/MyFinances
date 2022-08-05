package com.cadnunsdimir.myfinances.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "bank_account")
@JsonIgnoreProperties(ignoreUnknown = true)
public class BankAccount {

    @Id
    @GeneratedValue
    private Integer id;
    @Column(unique = true)
    private String name;

    @Column
    private Double initialValue;


//    private List<Transaction> transactions;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getInitialValue() {
        return initialValue;
    }

    public void setInitialValue(Double initialValue) {
        this.initialValue = initialValue;
    }

}
