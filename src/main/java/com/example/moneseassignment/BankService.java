package com.example.moneseassignment;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/bank")
@Produces("application/json")
@Consumes("application/json")
public interface BankService {

    @Path("/statement/{id}")
    @GET
    Statement getStatement(@PathParam("id") String id);

    @Path("/transfer")
    @POST
    Response transfer(Obejct transferRequest);
}
