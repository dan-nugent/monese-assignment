package co.uk.monese.assignment.pojos;

import co.uk.monese.assignment.entities.Transaction;

import java.math.BigDecimal;

public class Statement {

    private BigDecimal accountBalance;

    private Transaction[] transactions;

    public Statement() {
    }

    public Statement(BigDecimal accountBalance, Transaction[] transactions) {
        this.accountBalance = accountBalance;
        this.transactions = transactions;
    }

    public BigDecimal getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(BigDecimal accountBalance) {
        this.accountBalance = accountBalance;
    }

    public Transaction[] getTransactions() {
        return transactions;
    }

    public void setTransactions(Transaction[] transactions) {
        this.transactions = transactions;
    }
}
