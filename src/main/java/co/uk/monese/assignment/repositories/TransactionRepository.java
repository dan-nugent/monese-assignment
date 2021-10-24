package co.uk.monese.assignment.repositories;

import co.uk.monese.assignment.entities.Account;
import co.uk.monese.assignment.entities.Transaction;
import co.uk.monese.assignment.util.MoneseEntityManager;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class TransactionRepository {

    public TransactionRepository() {
    }

    public List<Transaction> getTransactionHistoryForAccount(Account account) {
        Query query = MoneseEntityManager.create().createQuery("SELECT t FROM Transaction t WHERE t.sender.accountId = :accountId OR t.recipient.accountId = :accountId ORDER BY transactionDate DESC");
        query.setParameter("accountId", account.getAccountId());
        return (List<Transaction>) query.getResultList();
    }

    public void saveTransaction(Transaction transaction) {
        EntityManager entityManager = MoneseEntityManager.create();
        entityManager.getTransaction().begin();
        entityManager.persist(transaction);
        entityManager.getTransaction().commit();
    }
}
