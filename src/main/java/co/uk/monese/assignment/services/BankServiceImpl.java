package co.uk.monese.assignment.services;

import co.uk.monese.assignment.controllers.BankServiceController;
import co.uk.monese.assignment.entities.Account;
import co.uk.monese.assignment.entities.Transaction;
import co.uk.monese.assignment.pojos.Statement;
import co.uk.monese.assignment.pojos.TransactionRequest;
import co.uk.monese.assignment.util.MoneseEntityManager;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.core.Response;
import java.math.BigDecimal;
import java.util.Date;

public class BankServiceImpl implements BankService {

    private BankServiceController bankServiceController;

    public BankServiceImpl() {
    }

    @Inject
    public BankServiceImpl(BankServiceController bankServiceController) {
        this.bankServiceController = bankServiceController;
    }

    @Override
    public Response getStatement(String id) {
        Statement statement = bankServiceController.getStatement(Integer.valueOf(id));
        return Response.ok(statement).build();
    }

    @Override
    public Response createTransaction(TransactionRequest transactionRequest) {
        //TODO: I would possibly modify this to return a custom response object that contains more granularity
        // about why an error has occurred so that a front-end/requester can handle appropriately. Due to timeboxing
        // I have not implemented this
        try {
            EntityManager em = MoneseEntityManager.create();
            Transaction transaction = new Transaction(null, em.find(Account.class, 1), em.find(Account.class, 2), new BigDecimal("22.22"), new Date());
            em.persist(transaction);
            bankServiceController.attemptTransaction(transactionRequest);
            return Response.ok().build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
}
