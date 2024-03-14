package com.turing.api.proxy;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class MathProxy {
    public static Function<Integer,Integer> absInt = Math::abs;
    /*public static Function<Double, Integer> ceilInt = Math::ceil;
    public static Function<Double, Integer> roundInt = Math::round;
    public static Function<Double, Integer> floorInt = Math::floor;*/
    public static BiFunction<Integer,Integer,Integer> maxInt = Math::max;
    public static BiFunction<Integer,Integer,Integer> minInt = Math::min;
    public static Function<String, Integer> parseInt = Integer::parseInt;



    public static Function<Double,Double> absDouble = Math::abs;
    /*public static Function<Double, Integer> ceilDouble = Math::ceil;
    public static Function<Double, Integer> roundDouble = Math::round;
    public static Function<Double, Integer> floorDouble = Math::floor;*/
    public static BiFunction<Double,Double,Double> maxDouble = Math::max;
    public static BiFunction<Double,Double,Double> minDouble = Math::min;


    public static Supplier<Double> randomDouble = Math::random;
    public static BiFunction<Integer,Integer,Integer> randomInt = (a, b) -> (int) (Math.random()* (b-a)+a);

    //Integer.parseInt
}
