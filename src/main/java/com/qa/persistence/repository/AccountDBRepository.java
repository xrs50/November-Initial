package com.qa.persistence.repository;

import com.qa.persistence.domain.Account;
import com.qa.util.JSONUtil;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

@Transactional(SUPPORTS)
@Default
public class AccountDBRepository implements AccountRepository{

    @PersistenceContext(unitName = "primary")
    private EntityManager manager;

    @Inject
    private JSONUtil util;

    @Override
    public String getAllAccounts(){
        TypedQuery<Account> query = manager.createQuery("SELECT a FROM Account a order by a.accountNumber asc ", Account.class);
        return util.getJSONForObject(query.getResultList());
    }

    @Override
    @Transactional(REQUIRED)
    public String createAnAccount(String account) {
        Account account1 = util.getObjectForJSON(account, Account.class);
        manager.persist(account1);
        return "{\"message\": \"account has been sucessfully added\"}";
    }

    @Override
    @Transactional(REQUIRED)
    public String updateAnAccount(long id, String accountToUpdate) {
        Account updatedAccount = util.getObjectForJSON(accountToUpdate, Account.class);
        Account accountFromDB = findAnAccount(id);
        if(accountFromDB != null){
            accountFromDB = updatedAccount;
            manager.merge(accountFromDB);
        }
        return "{\"message\": \"The account was successfully updated\"}";
    }

    @Override
    @Transactional(REQUIRED)
    public String deleteAnAccount(long id) {
        Account accountInDB = findAnAccount(id);
        if(accountInDB != null){
            manager.remove(accountInDB);
        }
        return "{\"message\": \"The account was successfully deleted\"}";
    }

    private Account findAnAccount(Long id){
        return manager.find(Account.class, id);
    }

    public void setManager(EntityManager manager){
        this.manager = manager;
    }

    public void setUtil(JSONUtil util){
        this.util = util;
    }
}
