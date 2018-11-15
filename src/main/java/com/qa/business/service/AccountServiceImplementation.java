package com.qa.business.service;

import com.qa.business.service.AccountService;
import com.qa.persistence.domain.Account;
import com.qa.persistence.repository.AccountRepository;
import com.qa.util.JSONUtil;

import javax.inject.Inject;

public class AccountServiceImplementation implements AccountService {

    @Inject
    private AccountRepository repository;
    private JSONUtil util;

    @Override
    public String getAllAccounts() {
        return repository.getAllAccounts();
    }

    @Override
    public String createAnAccount(String account) {
        Account account1 = util.getObjectForJSON(account, Account.class);
        if(account1.getAccountNumber() == 9999){
            return "{\"message\": \"This account number is blocked\"}";
        }
        else{
            return repository.createAnAccount(account);
        }
    }

    @Override
    public String updateAnAccount(long id, String accountToUpdate) {
        return repository.updateAnAccount(id, accountToUpdate);
    }

    @Override
    public String deleteAnAccount(long id) {
        return repository.deleteAnAccount(id);
    }

    public void setRepository(AccountRepository repository){
        this.repository = repository;
    }


}
