package ru.job4j.function;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.*;

public class FunctionalInterfaces {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        BiConsumer<Integer, String> biCon = (n, s) -> map.put(n, s);
        List<String> list = List.of("one", "two", "three", "four", "five", "six", "seven");
        for (int i = 0; i < list.size(); i++) {
            biCon.accept(i + 1, list.get(i));
        }

        Predicate<Integer> pred = (n) -> n % 2 == 0 || map.get(n).length() == 4;
        for (Integer i : map.keySet()) {
            if (pred.test(i)) {
                System.out.println("key: " + i + " value: " + map.get(i));
            }
        }

        Supplier<List<String>> sup = () -> new ArrayList<>(map.values());
        List<String> strings = sup.get();

        Consumer<String> con = (s) -> System.out.println(s);
        Function<String, String> func = s -> s.toUpperCase();
        for (String s : strings) {
            con.accept(func.apply(s));
        }
    }
}