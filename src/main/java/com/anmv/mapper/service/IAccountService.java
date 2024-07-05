package com.anmv.mapper.service;

import com.anmv.mapper.entities.Account;
import com.anmv.mapper.entities.form.CreateAccountForm;

import java.util.List;

public interface IAccountService {
    List<Account> getAllAccounts(String search);

    List<Account> getAccountByUsername(String username);

    Account getAccountById(int id);

    void createAccount(CreateAccountForm form);
}
