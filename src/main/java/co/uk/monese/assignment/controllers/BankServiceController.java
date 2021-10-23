package co.uk.monese.assignment.controllers;

import co.uk.monese.assignment.entities.Account;
import co.uk.monese.assignment.entities.Transaction;
import co.uk.monese.assignment.pojos.Statement;
import co.uk.monese.assignment.pojos.TransactionRequest;
import co.uk.monese.assignment.repositories.AccountRepository;
import co.uk.monese.assignment.repositories.TransactionRepository;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class BankServiceController {

    private AccountRepository accountRepository;

    private TransactionRepository transactionRepository;

    public BankServiceController() {
    }

    @Inject
    public BankServiceController(AccountRepository accountRepository, TransactionRepository transactionRepository) {
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }

    public Statement getStatement(Integer id) {
        Account account = accountRepository.getAccountForId(id);
        if (account == null) {
            throw new IllegalArgumentException(String.format("No account exists with id : %s", id.toString()));
        }
        List<Transaction> transactionHistory = transactionRepository.getTransactionHistoryForAccount(account);
        return new Statement(account.getBalance(), transactionHistory.toArray(new Transaction[0]));
    }

    public void attemptTransaction(TransactionRequest transactionRequest) {
        Account sender = accountRepository.getAccountForId(transactionRequest.getSenderId());
        Account recipient = accountRepository.getAccountForId(transactionRequest.getRecipientId());

        BigDecimal transactionAmount = transactionRequest.getAmount();
        if (transactionAmount.compareTo(sender.getBalance()) == 1) {
            throw new IllegalStateException("The sender does not have enough funds to perform this transaction.");
        }

        sender.setBalance(sender.getBalance().subtract(transactionAmount));
        accountRepository.updateAccount(sender);
        recipient.setBalance(recipient.getBalance().add(transactionAmount));
        accountRepository.updateAccount(recipient);

        Transaction transaction = new Transaction(null, sender, recipient, transactionAmount, new Date());
        transactionRepository.saveTransaction(transaction);
    }
}
