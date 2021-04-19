package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class EasyStream {
    private List<Integer> source;

    public EasyStream(List<Integer> source) {
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
        source = rsl;
        return this;
    }

    public EasyStream filter(Predicate<Integer> fun) {
        List<Integer> rsl = new ArrayList<>();
        for (Integer num : source) {
            if (fun.test(num)) {
                rsl.add(num);
            }
        }
        source = rsl;
        return this;
    }

    public List<Integer> collect() {
        return source;
    }
}