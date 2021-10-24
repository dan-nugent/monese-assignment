package co.uk.monese.assignment.services;

import co.uk.monese.assignment.controllers.BankServiceController;
import co.uk.monese.assignment.pojos.Statement;
import co.uk.monese.assignment.pojos.TransactionRequest;

import javax.inject.Inject;
import javax.ws.rs.core.Response;

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
        // about why an error has occurred so that a front-end/requester can handle appropriately.
        try {
            bankServiceController.attemptTransaction(transactionRequest);
            return Response.ok().build();
        } catch (IllegalStateException e) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
}
