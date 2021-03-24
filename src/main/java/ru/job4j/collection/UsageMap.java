package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("ivanov@yandex.ru", "Ivanov Ivan Ivanovich");
        map.put("petrov@mail.ru", "Petrov Petr Petrovich");
        for (Map.Entry<String, String> entry: map.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}
