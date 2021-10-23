package co.uk.monese.assignment.repositories;

import co.uk.monese.assignment.entities.Account;
import co.uk.monese.assignment.util.MoneseEntityManager;

public class AccountRepository {

    public AccountRepository() {
    }

    public Account getAccountForId(Integer id) {
        return MoneseEntityManager.create().find(Account.class, id);
    }

    public void updateAccount(Account account) {
        MoneseEntityManager.create().merge(account);
    }
}
