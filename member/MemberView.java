package com.turing.api.member;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class MemberView {
    public static void main( Scanner sc ) throws SQLException {
        MemberController controller = new MemberController();
        String msg = controller.addMembers();
        System.out.println(" addMembers 결과 : ");


        /*while (true){
            System.out.println("[사용자메뉴] 0-종료\n " +
                    "1-회원가입\n " +
                    "2-로그인\n " +
                    "3-ID검색\n " +
                    "4-비번변경\n" +
                    "5-탈퇴\n " +
                    "6-회원목록\n " +
                    "7-이름검색\n" +
                    "8-직업검색\n" +
                    "9-회원수\n"  +
                     "touch- 테이블생성\n" +
                    "rm-테이블 삭제 ");
            switch (sc.next()){
                case "0":
                    System.out.println("종료");return;
                case "1":
                    System.out.println("1-회원가입");
                    System.out.println("회원가입 결과 : "+ controller.save(sc));
                    break;
                case "2":
                    System.out.println("2-로그인");
                    System.out.println("로그인 결과 : " + controller.login(sc));
                    break;
                case "3":


                    break;
                case "4":
                    System.out.println("4-비번변경");

                    break;
                case "5":
                    System.out.println("5-탈퇴");
                    break;
                case "6":
                    System.out.println("6-회원목록");
                    List<?> members = controller.findMembers();
                    members.forEach(i -> System.out.println(i));
                    break;
                case "7":
                    System.out.println("7-이름검색");
                    break;
                case "8":
                    System.out.println("8-직업검색");
                    break;
                case "9":
                    System.out.println("9-회원수");
                    break;
                case "touch":
                    System.out.println("테이블생성");
                    System.out.println(controller.createTable());
                    break;
                case "rm":
                    System.out.println("테이블 삭제");
                    System.out.println(controller.deleteTable());
                    break;

            }

        }*/

    }
}