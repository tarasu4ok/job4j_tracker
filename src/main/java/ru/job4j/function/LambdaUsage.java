package ru.job4j.function;

import java.util.Comparator;
import java.util.List;

public class LambdaUsage {
    public static void main(String[] args) {
        Comparator<String> cmpText = (left, right) -> {
            System.out.println("compare two strings: " + left.length() + ":" + right.length());
            return left.compareTo(right);
        };

        Comparator<String> cmpDescSize = (left, right) -> {
            System.out.println("compare length of two strings with desc sort: "
                    + left.length() + ":" + right.length());
            return Integer.compare(right.length(), left.length());
        };
    }
}
