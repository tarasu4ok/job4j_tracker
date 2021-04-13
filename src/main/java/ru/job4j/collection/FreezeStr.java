package ru.job4j.collection;
import java.util.*;

/**
 * Формирует Map<String, Integer> из строки left, где ключом является символ строки, а значением
 * количество его вхождений.
 * Далее, пробегая в цикле по каждому символу строки right, мы проверяем есть ли он в этой мапе.
 * Если находим, то обновляем мапу, вычитая 1 из количества вхождений, учитывая таким образом
 * факт использования символа во второй строке.
 * В случае если на каком-то символе оказалось, что его в начальной мапе нет или количество
 * вхождений стало равным 0, возвращаем false
 * В случае успешного прохода второй строки до конца, проверяем, что все символы из мапы были
 * задействованы (все значения равны 0). Если это не так, то аналогично возвращаем false.
 * Иначе считаем, что строки идентичны, возвращая true
 */
public class FreezeStr {
    public static boolean eq(String left, String right) {
        left = left.toLowerCase()
                .replace(" ", "");
        right = right.toLowerCase()
                .replace(" ", "");
        String[] chars = left.split("");
        Map<String, Integer> leftMap = new HashMap<>();
        for (String chr : chars) {
            leftMap.computeIfPresent(chr, (key, value) -> value + 1);
            leftMap.putIfAbsent(chr, 1);
        }
        for (int i = 0; i < right.length(); i++) {
            String index = String.valueOf(right.charAt(i));
            if (!leftMap.containsKey(index) || (leftMap.get(index) == 0)) {
                return false;
            } else {
                leftMap.computeIfPresent(index, (key, value) -> value - 1);
            }
        }
        for (Integer value : leftMap.values()) {
            if (!Integer.valueOf(0).equals(value)) {
                return false;
            }
        }
        return true;
    }
}
