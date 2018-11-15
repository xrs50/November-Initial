package com.qa.persistence.repository;

public interface AccountRepository {
    String getAllAccounts();
    String createAnAccount(String account);
    String updateAnAccount(long id, String accountToUpdate);
    String deleteAnAccount(long id);
}
