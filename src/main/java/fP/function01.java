package fP;

import java.util.function.Function;

//https://flyingbytes.github.io/programming/java8/functional/part1/2017/01/23/Java8-Part1.html
public class function01 {

    public static Integer compute(Function<Integer,Integer> function, Integer value){
        return function.apply(value);
    }

    private static Integer invert(Integer value) {
        return -value;
    }


    public static Integer InvertTheNumber() {
        Integer toInvert = 5;
        Function<Integer, Integer> invertFunction = function01::invert;
        return compute(invertFunction, toInvert);
    }

    public static void main(String[] args) {
        System.out.println(InvertTheNumber());
    }


}
