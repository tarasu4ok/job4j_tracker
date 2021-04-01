package ru.job4j.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamUsage {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 4, -7, 8, -12, 25, -2, 9, 0);
        List<Integer> positiveNumbers = numbers
                .stream()
                .filter(n -> n > 0)
                .collect(Collectors.toList());
        positiveNumbers.forEach(System.out::println);
    }
}
