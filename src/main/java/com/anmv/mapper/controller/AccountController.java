package com.anmv.mapper.controller;

import com.anmv.mapper.entities.Account;
import com.anmv.mapper.entities.dto.AccountDTO;
import com.anmv.mapper.service.IAccountService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "api/v1/accounts")
public class AccountController {
    @Autowired
    private IAccountService service;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping()
    public List<AccountDTO> getAllAccounts(@RequestParam(value = "search", required = false) String search){
        List<Account> listAccounts = service.getAllAccounts(search);
        /*
        List<AccountDTO> returnList = new ArrayList<>();
        for (Account account : listAccounts){
            AccountDTO tempAccount = new AccountDTO(account.getId(), account.getUsername(), account.getDepartment().getName());
            returnList.add(tempAccount);
        } */

        List<AccountDTO> returnList = modelMapper.map(listAccounts, new TypeToken<List<AccountDTO>>(){}.getType());

        return returnList;
    }

    @GetMapping(value = "/username")
    public List<AccountDTO> getAllAccountByName(@RequestParam(value = "username", required = false) String username){
        List<Account> listAccounts = service.getAccountByUsername(username);

        List<AccountDTO> returnList = modelMapper.map(listAccounts, new TypeToken<List<AccountDTO>>(){}.getType());

        return returnList;
    }


    @GetMapping(value = "/{id}")
    public Account getAccountById(@PathVariable(name = "id") int id){
        return service.getAccountById(id);
    }
}
