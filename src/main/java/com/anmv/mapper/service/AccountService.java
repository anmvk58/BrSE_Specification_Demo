package com.anmv.mapper.service;

import com.anmv.mapper.entities.Account;
import com.anmv.mapper.repository.IAccountRepository;
import com.anmv.mapper.specification.AccountSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService implements IAccountService{
    @Autowired
    private IAccountRepository repository;

    public List<Account> getAllAccounts(String search){
        Specification<Account> where = AccountSpecification.buildWhere(search);
        return repository.findAll(where);
    }

    @Override
    public List<Account> getAccountByUsername(String username) {
        return repository.findByUsername(username);
    }

    public Account getAccountById(int id){
        return repository.findById(id).get();
    }
}
