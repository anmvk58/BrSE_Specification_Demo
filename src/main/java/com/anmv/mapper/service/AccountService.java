package com.anmv.mapper.service;

import com.anmv.mapper.entities.Account;
import com.anmv.mapper.entities.form.CreateAccountForm;
import com.anmv.mapper.repository.IAccountRepository;
import com.anmv.mapper.specification.AccountSpecification;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService implements IAccountService{
    @Autowired
    private IAccountRepository repository;

    @Autowired
    private ModelMapper modelMapper;

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

    @Override
    public void createAccount(CreateAccountForm form) {
        TypeMap<CreateAccountForm, Account> typeMap = modelMapper.getTypeMap(CreateAccountForm.class, Account.class);
        if (typeMap == null){
            modelMapper.addMappings(new PropertyMap<CreateAccountForm, Account>() {
                @Override
                protected void configure() {
                    skip(destination.getId());
                }
            });
        }

        Account account = modelMapper.map(form, Account.class);
        System.out.println("Hello my name is ...");
        repository.save(account);
    }
}
