package com.example.moneseassignment;

import java.math.BigDecimal;
import java.util.List;

public class Statement {

    private BigDecimal accountBalance;

    private List<Transaction> transactions;

    public Statement() {
    }

    public Statement(BigDecimal accountBalance, List<Transaction> transactions) {
        this.accountBalance = accountBalance;
        this.transactions = transactions;
    }

    public BigDecimal getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(BigDecimal accountBalance) {
        this.accountBalance = accountBalance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}
