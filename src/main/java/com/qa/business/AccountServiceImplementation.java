package com.qa.business;

import com.qa.persistence.repository.AccountRepository;

import javax.inject.Inject;

public class AccountServiceImplementation implements AccountService{

    @Inject
    private AccountRepository repository;

    @Override
    public String getAllAccounts() {
        return repository.getAllAccounts();
    }

    @Override
    public String createAnAccount(String account) {
        return repository.createAnAccount(account);
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
