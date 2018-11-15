package com.qa.interoperability.rest;

import com.qa.business.service.AccountService;

import javax.inject.Inject;
import javax.ws.rs.*;

@Path("/account")
public class AccountRest {

    @Inject
    private AccountService service;

    @Path("/json")
    @GET
    @Produces({"application/json"})
    public String getAllAccounts(){
        return service.getAllAccounts();
    }

    @Path("/json")
    @POST
    @Produces({"application/json"})
    public String addAnAccount(String account){
        return service.addAnAccount(account);
    }

    @Path("/json/{id}")
    @PUT
    @Produces({"application/json"})
    public String updateAnAccount(@PathParam("id") Long id, String accountToUpdate){
        return service.updateAnAccount(id, accountToUpdate);
    }

    @Path("/json/{id}")
    @DELETE
    @Produces({"application/json"})
    public String deleteAnAccount(@PathParam("id") Long id){
        return service.deleteAnAccount(id);
    }

    public void setService(AccountService service) {
        this.service = service;
    }
}
