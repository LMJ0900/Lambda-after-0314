package com.turing.api.article;

import java.sql.SQLException;
import java.util.Scanner;

public class ArticleView {
    public static void main(Scanner sc) throws SQLException {
        ArticleController controller = new ArticleController();

        while (true){
            System.out.println("[메뉴] -0 종료\n" +
                    "1- 글 목록");
            switch (sc.next()){
                case "0" :
                    System.out.println("종료");
                    return;
                case "1" :
                    System.out.println("글 목록 : ");

                    controller.articlesList(sc).forEach(i -> System.out.println(i));

                    break;
            }
        }
    }
}
