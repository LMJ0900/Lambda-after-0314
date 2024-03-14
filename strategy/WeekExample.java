package com.turing.api.strategy;


import java.util.Scanner;

enum Week{
    monday {
        @Override
        public String day() {
            return "월요일입니다";
        }
    },
    tuesday{
        @Override
        public String day() {
            return "화요일입니다";
        }
    },
    wednesday{
        @Override
        public String day() {
            return "수요일입니다";
        }
    },
    thursday{
        @Override
        public String day() {
            return "목요일입니다";
        }
    },
    friday{
        @Override
        public String day() {
            return "금요일입니다";
        }
    },
    saturday{
        @Override
        public String day() {
            return "토요일입니다";
        }
    },
    sunday{
        @Override
        public String day() {
            return "일요일입니다";
        }
    };


    public abstract String day();
}
public class WeekExample {
    public static String weekExample(Week week){
        return week.day();
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("무슨요일입니까");
        System.out.println(WeekExample.weekExample( Week.valueOf(sc.next())));
    }
}
