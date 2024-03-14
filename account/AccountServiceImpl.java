package com.turing.api.account;

import com.turing.api.common.AbstractService;
import com.turing.api.enums.Messenger;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class AccountServiceImpl extends AbstractService<Account> implements AccountService {
    private static AccountServiceImpl instance = new AccountServiceImpl();

    private AccountServiceImpl() {
        this.accounts = new ArrayList<>();
    }

    public static AccountServiceImpl getInstance() {
        return instance;
    }

    List<Account> accounts = new ArrayList<>();




    @Override
    public String deposit(Account account) {
        return null;
    }

    @Override
    public String withdraw(Account account) {
        return null;
    }

    @Override
    public String getBalance(String accountNumber) {
        return null;
    }


    @Override
    public Messenger save(Account account) {
        return null;
    }

    @Override
    public List<Account> findAll() {
        return null;
    }

    @Override
    public Optional<Account> findAById(Long id) {
        return Optional.empty();
    }

    @Override
    public String count() {
        return null;
    }

    @Override
    public Optional<Account> getOne(String id) {
        return Optional.empty();
    }

    @Override
    public String delete(Account account) {
        return null;
    }

    @Override
    public String deleteAll() {
        return null;
    }

    @Override
    public Boolean existById(Long id) {
        return null;
    }
}
