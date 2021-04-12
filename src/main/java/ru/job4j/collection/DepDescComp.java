package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String o1Substr = o1.substring(0, o1.contains("/") ? o1.indexOf("/") : o1.length());
        String o2Substr = o2.substring(0, o2.contains("/") ? o2.indexOf("/") : o2.length());
        return o2Substr.compareTo(o1Substr) != 0 ? o2Substr.compareTo(o1Substr) : o1.compareTo(o2);
    }
}
