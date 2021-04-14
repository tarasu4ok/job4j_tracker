package ru.job4j.collection;
import java.util.*;

public class Article {
    public static boolean generateBy(String origin, String line) {
        origin = origin
                .toLowerCase()
                .replaceAll("\\p{P}", "");
        String[] words = origin.split(" ");
        Set<String> originSet = new HashSet<>();
        Collections.addAll(originSet, words);

        line = line
                .toLowerCase()
                .replaceAll("\\p{P}", "");
        List<String> lineList = List.of(line.split(" "));
        for (String word : lineList) {
            if (!originSet.contains(word)) {
                return false;
            }
        }
        return true;
    }
}
