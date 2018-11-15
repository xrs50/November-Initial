package com.qa.persistence.repository;

import com.qa.persistence.domain.Account;
import com.qa.util.JSONUtil;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import java.util.List;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

@Transactional(SUPPORTS)
public class AccountService {

    JSONUtil util = new JSONUtil();
    @PersistenceContext(unitName = "primary")
    private EntityManager manager;

    @Transactional(REQUIRED )
    public String createAnAccount(String account){
        //Account aharan = util.getObjectForJSON(account, Account.class);
        manager.persist(account);
        return "{\"message\": \"account successfully added\"}";
    }

    public List<Account> getAllAccounts(){
        TypedQuery<Account> query = manager.createQuery("SELECT a FROM Account a order by a.accountNumber asc ", Account.class);
        return query.getResultList();
    }

    public Account findAnAccount(Long id){
        return manager.find(Account.class, id);
    }

    @Transactional(REQUIRED)
    public void updateAnAccount(Long id, String firstName, String lastName, int accountNumber){
        Account updatedAccount = manager.find(Account.class, id);
        updatedAccount.setId(id);
        updatedAccount.setFirstName(firstName);
        updatedAccount.setLastName(lastName);
        updatedAccount.setAccountNumber(accountNumber);
        manager.merge(updatedAccount);
    }

    @Transactional(REQUIRED)
    public void deleteAccount(String account){
        manager.remove(account);
    }

}
