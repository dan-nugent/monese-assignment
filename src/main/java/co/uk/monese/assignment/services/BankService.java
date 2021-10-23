package co.uk.monese.assignment.services;

import co.uk.monese.assignment.pojos.TransactionRequest;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/bank")
@Produces("application/json")
@Consumes("application/json")
public interface BankService {

    @Path("/statement/{id}")
    @GET
    Response getStatement(@PathParam("id") String accountId);

    @Path("/transaction")
    @POST
    Response createTransaction(TransactionRequest transactionRequest);
}
