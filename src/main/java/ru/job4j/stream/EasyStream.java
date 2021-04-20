package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class EasyStream {
    private List<Integer> source;

    private EasyStream(List<Integer> source) {
        this.source = source;
    }

    public static EasyStream of(List<Integer> source) {
        return new EasyStream(source);
    }

    public EasyStream map(Function<Integer, Integer> fun) {
        List<Integer> rsl = new ArrayList<>();
        for (Integer num : source) {
            rsl.add(fun.apply(num));
        }
        return new EasyStream(rsl);
    }

    public EasyStream filter(Predicate<Integer> fun) {
        List<Integer> rsl = new ArrayList<>();
        for (Integer num : source) {
            if (fun.test(num)) {
                rsl.add(num);
            }
        }
        return new EasyStream(rsl);
    }

    public List<Integer> collect() {
        return source;
    }
}