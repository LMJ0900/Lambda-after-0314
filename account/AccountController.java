package com.turing.api.account;

import com.turing.api.enums.Messenger;

import java.util.List;
import java.util.Scanner;

public class AccountController {
   AccountServiceImpl accountService;
   public static AccountController instance = new AccountController();

    public static AccountController getInstance() {
        return instance;
    }

    public AccountController() {
        this.accountService = AccountServiceImpl.getInstance();
    }


    public Messenger createAccount(Scanner sc) {
        System.out.println("이름, 주민번호, 전화번호, " +
                "계좌번호, 비밀번호를 입력해주세요");
        return accountService.save(Account.builder()
                .id(sc.nextLong())
                .accountNumber(sc.next())
                .accountHolder(sc.next())
                .balance(sc.nextDouble())
                .transactionDate(null)
                .build());
    }

    public String deposit(Scanner sc) {
        return accountService.deposit(Account.builder()
                .id(sc.nextLong())
                .accountNumber(sc.next())
                .accountHolder(sc.next())
                .balance(sc.nextDouble())
                .transactionDate(null)
                .build());

    }

    public String withdraw(Scanner sc) {
        return accountService.withdraw(Account.builder()
                .id(sc.nextLong())
                .accountNumber(sc.next())
                .accountHolder(sc.next())
                .balance(sc.nextDouble())
                .transactionDate(null)
                .build());
    }

    public String getBalance(Scanner sc) {
        return accountService.getBalance(sc.next());
    }

    public String cancelAccount(Scanner sc) {
        return accountService.delete(Account.builder().accountNumber(sc.next()).build());
    }

    public List<?> getAccounts() {
        return accountService.findAll();
    }
}
