package com.qa.business.service;

public interface AccountService {
    String getAllAccounts();
    String createAnAccount(String account);
    String updateAnAccount(long id, String accountToUpdate);
    String deleteAnAccount(long id);

}
