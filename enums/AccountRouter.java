package com.turing.api.enums;

import com.turing.api.account.AccountController;

import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Stream;

public enum AccountRouter {
    createAccount("1",i->{

        return "계좌생성";
    }),
    deposit("2",i->{
        AccountController.getInstance().deposit(i);
                return "완료";}),
    withdraw("3",i->"출금"),
    getBalance("4",i->"잔고 확인"),
    cancelAccount("5",i->"계좌 삭제"),
    accountList("6",i->"accountList"),
    exit("0",i->"종료"),
    ;
    private final String name;
    private final Function<Scanner,String>function;

    AccountRouter(String name, Function<Scanner , String> function) {
        this.name = name;
        this.function = function;
    }

    public static void getView(Scanner sc) {
        System.out.println("[메뉴] 0-종료\n " +
                "1-계좌생성\n " +
                "2-입금\n " +
                "3-출금\n " +
                "4-잔고 확인\n " +
                "5-계좌 삭제\n" +
                "6-accountList ");
        String msg = sc.next();
        Stream.of(values())
                .filter(i->i.name.equals(msg))
                .findAny()
                .orElseGet(()->exit)
                .function.apply(sc);
    }
}
