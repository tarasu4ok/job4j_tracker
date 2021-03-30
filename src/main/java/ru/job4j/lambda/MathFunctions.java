package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class MathFunctions {
    public static List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> rsl = new ArrayList<>();
        for (int index = start; index < end; index++) {
            rsl.add(func.apply((double) index));
        }
        return rsl;
    }

    public static void main(String[] args) {
        List<Double> rsl = diapason(5, 8, x -> x * 2 + 1);
        for (Double el:rsl) {
            System.out.println(el);
        }
    }
}
