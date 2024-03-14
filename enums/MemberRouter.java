package com.turing.api.enums;

import com.turing.api.member.MemberController;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Stream;

public enum MemberRouter {
    Join("1",sc->{
        System.out.println("회원가입");
        try {
            MemberController.getInstance().save(sc);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;}),
    login("2",sc->{
        System.out.println("로그인");
        MemberController.getInstance().login(sc);
        return true;}),
    IdSearch("3",sc->{
        System.out.println("ID검색");
        return true;}),
    PasswordChange("4",sc->{
        System.out.println("비번변경");
        MemberController.getInstance().updatePassword(sc);
        return true;}),
    Withdraw("5",sc->{
        System.out.println("탈퇴");
        MemberController.getInstance().delete(sc);
        return true;}),
    MemberList("ls",sc->{
        System.out.println("회원목록");
        MemberController.getInstance().findAll();
        return true;}),
    NameSearch("7",sc->{
        System.out.println("이름검색");
        return true;}),
    JobSearch("8",sc->{
        System.out.println("직업검색");
        MemberController.getInstance().findMembersByJob(sc);
        return true;}),
    MemberCount("9",sc->{
        System.out.println("회원수");
        MemberController.getInstance().count();
        return true;}),
    CreateTable("touch",sc->{
        System.out.println("테이블생성");
        try {
            MemberController.getInstance().createTable();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;}),
    dereateTable("rm",sc->{
        System.out.println("테이블삭제");
        try {
            MemberController.getInstance().deleteTable();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;}),
    exit("0",sc->{
        System.out.println("종료");
        return false;})
    ;

    private final  String name;
    private final Predicate<Scanner> predicate;

    MemberRouter(String name, Predicate<Scanner> predicate) {
        this.name = name;
        this.predicate = predicate;
    }

    public static boolean getView(Scanner sc) {
        System.out.println("[사용자메뉴] 0-종료\n " +
                "1-회원가입\n " +
                "2-로그인\n " +
                "3-ID검색\n " +
                "4-비번변경\n" +
                "5-탈퇴\n " +
                "ls-회원목록\n " +
                "7-이름검색\n" +
                "8-직업검색\n" +
                "9-회원수\n" +
                "touch-테이블생성\n" +
                "rm-테이블삭제" +
                "");
        String menu = sc.next();
        return Stream.of(values())
                .filter(i->i.name.equals(menu))
                .findAny()
                .orElseGet(()->exit)
                .predicate.test(sc);
    }
}