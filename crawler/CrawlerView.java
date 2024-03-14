package com.turing.api.crawler;

import org.jsoup.nodes.Element;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.Iterator;
public class CrawlerView {
    public static void main(Scanner sc) throws IOException {
        CrawlerController controller = new CrawlerController();
        while (true){
            System.out.println("[사용자메뉴] 0-종료\n " +
                    "1-벅스뮤직\n " +
                    "2-멜론차트\n " +
                    "3-ID검색\n " +
                    "4-비번변경\n" +
                    "5-탈퇴\n " +
                    "6-회원목록\n " +
                    "7-이름검색\n" +
                    "8-직업검색\n" +
                    "9-회원수");
            switch (sc.next()){
                case "0":
                    System.out.println("종료");return;
                case "1":
                    System.out.println("1-벅스뮤직");
                    Map<String , ?>map = controller.findBugsMusic(sc);
                    Iterator<Element> title = (Iterator<Element>) map.get("title");
                    Iterator<Element> rank = (Iterator<Element>) map.get("rank");
                    Iterator<Element> artist = (Iterator<Element>) map.get("artist");

                    System.out.println("벅스뮤직 결과 : " );
                    while (title.hasNext()) {
                        System.out.println(rank.next().text() + "위 " + artist.next().text() + " - " + title.next().text());
                    }
                    break;
                case "2":
                    System.out.println("2-멜론뮤직");
                    Map<String, ?>map1 = controller.findMelonMusic(sc);
                    Iterator<Element> title1 = (Iterator<Element>) map1.get("title");
                    Iterator<Element> rank1 = (Iterator<Element>) map1.get("rank");
                    Iterator<Element> artist1 = (Iterator<Element>) map1.get("artist");

                    System.out.println("멜론뮤직 결과 : " );
                    while (title1.hasNext()) {
                        System.out.println(rank1.next().text() + "위 " + artist1.next().text() + " - " + title1.next().text());
                    }



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

            }

        }

    }
}
