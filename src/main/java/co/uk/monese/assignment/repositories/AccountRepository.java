package co.uk.monese.assignment.repositories;

import co.uk.monese.assignment.entities.Account;
import co.uk.monese.assignment.util.MoneseEntityManager;

import javax.persistence.EntityManager;

public class AccountRepository {

    public AccountRepository() {
    }

    public Account getAccountForId(Integer id) {
        return MoneseEntityManager.create().find(Account.class, id);
    }

    public void updateAccount(Account account) {
        EntityManager entityManager = MoneseEntityManager.create();
        entityManager.getTransaction().begin();
        entityManager.merge(account);
        entityManager.getTransaction().commit();
    }
}
