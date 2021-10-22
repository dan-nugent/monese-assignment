package com.example.moneseassignment;

import java.math.BigDecimal;

public class Transaction {

    private Account sender;

    private Account recipient;

    private BigDecimal amount;

    public Transaction() {
    }

    public Transaction(Account sender, Account recipient, BigDecimal amount) {
        this.sender = sender;
        this.recipient = recipient;
        this.amount = amount;
    }

    public Account getSender() {
        return sender;
    }

    public void setSender(Account sender) {
        this.sender = sender;
    }

    public Account getRecipient() {
        return recipient;
    }

    public void setRecipient(Account recipient) {
        this.recipient = recipient;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
