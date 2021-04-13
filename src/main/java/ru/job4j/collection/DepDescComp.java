package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] o1Array = o1.split("/", 2);
        String[] o2Array = o2.split("/", 2);
        int rsl = o2Array[0].compareTo(o1Array[0]);
        return rsl != 0 ? rsl : o1.compareTo(o2);
    }
}
