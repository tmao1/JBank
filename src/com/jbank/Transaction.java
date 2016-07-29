package com.jbank;

import java.util.Date;
import java.util.Random;

/**
 * Created by localadmin on 7/28/16.
 */
public class Transaction {
    private TransactionType type;
    private float amount;
    private Date date;
    private String id;

    public Transaction(float amount, TransactionType type) {
        Random rand = new Random();
        this.type = type;
        this.amount = amount;
        this.date = new Date();
        this.id = String.valueOf(Math.abs(rand.nextLong()));
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {

        return this.type.toString() + " " + this.amount + "  " + this.date + "  " + this.id;
    }
}
