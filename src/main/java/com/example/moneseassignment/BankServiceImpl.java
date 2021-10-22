package com.example.moneseassignment;

import javax.ws.rs.core.Response;

public class BankServiceImpl implements BankService {

    @Override
    public Statement getStatement(String id) {
        return null;
    }

    @Override
    public Response transfer(Obejct transferRequest) {
        return Response.ok().build();
    }
}
