package com.turing.api.strategy;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Supplier;

enum Rank{
    A(9,()-> "A입니다."),
    B(8, ()-> "B입니다"),
    C(7,()->"C입니다"),
    D(6,()->"D입니다"),
    E(5,()->"E입니다"),
    F(4,()->"F입니다"),
    ;
    private final int score;
    private final Supplier<String> supplier;

    Rank(int score, Supplier<String> supplier) {
        this.score = score;
        this.supplier = supplier;
    }

    public static String rating(int score){
        return getRank(score).supplier.get();
    }
    private static Rank getRank(int score1){
        return Arrays.stream(values())
                .filter(o -> o.score==score1/10)
                .findFirst().orElseThrow(() -> new IllegalArgumentException(""));
    }
}
public class Score {
    public static String rating(int score){
        return Rank.rating(score);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("점수를 입력하세요");
        System.out.println(rating(sc.nextInt()));
        // System.out.println(Rank.getResult(Rank.getRank(sc.nextInt())));

    }


}
