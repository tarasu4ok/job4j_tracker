package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int size = Math.min(left.length(), right.length());
        int rsl;
        for (int index = 0; index < size; index++) {
            rsl = Character.compare(left.charAt(index), right.charAt(index));
            if (rsl != 0) {
                return rsl;
            }
        }
        return (left.length() != right.length() ? Integer.compare(left.length(), right.length()) : 0);
    }

    public static void main(String[] args) {
        int res = new StringCompare().compare("ssd", "asd");
        System.out.println(res);
    }
}
