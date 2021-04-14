package ru.job4j.collection;
import java.util.*;

public class Article {
    public static boolean generateBy(String origin, String line) {
        origin = origin
                .toLowerCase()
                .replaceAll("\\p{P}", "");
        String[] words = origin.split(" ");
        Map<String, Integer> originMap = new HashMap<>();
        for (String word : words) {
            originMap.computeIfPresent(word, (key, value) -> value + 1);
            originMap.putIfAbsent(word, 1);
        }

        line = line
                .toLowerCase()
                .replaceAll("\\p{P}", "");
        String[] lineWords = line.split(" ");
        Map<String, Integer> lineMap = new HashMap<>();
        for (String word : lineWords) {
            lineMap.computeIfPresent(word, (key, value) -> value + 1);
            lineMap.putIfAbsent(word, 1);
        }

        for (Map.Entry<String, Integer> entry : lineMap.entrySet()) {
            if (!originMap.containsKey(entry.getKey())
                    || originMap.get(entry.getKey()) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }
}
