package com.qa.persistence.repository;

import com.qa.persistence.domain.Account;
import com.qa.util.JSONUtil;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
@Alternative
public class AccountMapRepository implements AccountRepository{

    private final long initial_count = 1L;
    private Map<Long, Account> accountMap;
    private long ID;

    @Inject
    private JSONUtil util;

    private void initAccountMap(){
        Account account = new Account(1, "Aharan", "Manoharan", 1234);
        accountMap.put(1L, account);
    }
    public AccountMapRepository(){
        this.accountMap = new HashMap<Long, Account>();
        ID = initial_count;
    }

    @Override
    public String getAllAccounts() {
        return util.getJSONForObject(accountMap.values());
    }

    @Override
    public String createAnAccount(String account) {
        ID++;
        Account newAccount = util.getObjectForJSON(account, Account.class);
        accountMap.put(ID, newAccount);
        return account;
    }

    @Override
    public String updateAnAccount(long id, String accountToUpdate) {
        Account newAccount = util.getObjectForJSON(accountToUpdate, Account.class);
        accountMap.put(id, newAccount);
        return accountToUpdate;
    }

    @Override
    public String deleteAnAccount(long id) {
        accountMap.remove(id);
        return "{\"message\": \"Account was successfully removed\"}";
    }
}
