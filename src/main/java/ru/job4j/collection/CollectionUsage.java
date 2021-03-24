package ru.job4j.collection;

import java.util.*;

import static java.util.List.of;

public class CollectionUsage {

    public static int generateAndSum(int first, int denominator, int count) {
        ArrayList<Integer> list = new ArrayList<>(count);
        int sum = 0;
        for (int i = 1; i <= count; i++) {
            int value = first * (int) Math.pow(denominator, (i - 1));
            list.add(value);
            sum += value;
        }
        return sum;
    }

    public static void main(String[] args) {
        /*
        String[] array = new String[]{"first", "second", "third", "fourth", "fifth"};
        List<String> list = new ArrayList<>(20);
        for (String el : array) {
            list.add(el);
        }
        for (String el : list) {
            System.out.println(el);
        }


        Set<String> strings = new HashSet<>(Set.of("one", "two", "three", "four", "five"));
        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()) {
            System.out.println(String.format("Next element exist? - %s.", iterator.hasNext()));
            System.out.println(iterator.next());
        }
        */

        /*
        System.out.println("========================");
        ListIterator<String> listIterator = list.listIterator();
        //String current = listIterator.next();
        //System.out.println("Current element: " + current);
        listIterator.next();
        listIterator.add("zero");
        while (listIterator.hasNext()) {
            if ("third".equals(listIterator.next())) {
                listIterator.remove();
            }
        }

        System.out.println("========================");
        while (listIterator.hasPrevious()) {
            System.out.println(listIterator.previous());
        }
*/
        //int sum = generateAndSum(1, 2, 4);
        //System.out.println(sum);
        /*
        String str = new String("javascript");
        String[] arrStr = str.split("", 0);
        List<String> list = Arrays.asList(arrStr);
        list.sort(String.CASE_INSENSITIVE_ORDER);
        StringBuilder sb = new StringBuilder();
        for (String el:list) {
            System.out.println(el);
            sb.append(el);
        }
        System.out.println(sb.toString());

         */
        //TestModel tm = new TestModelExt();
        //tm.print();
    }
}
