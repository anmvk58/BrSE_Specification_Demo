package com.anmv.mapper.service;

import com.anmv.mapper.entities.Account;

import java.util.List;

public interface IAccountService {
    List<Account> getAllAccounts(String search);

    List<Account> getAccountByUsername(String username);

    Account getAccountById(int id);
}
