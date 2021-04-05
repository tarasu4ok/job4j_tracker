package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class FlatMapUsageTest {
    @Test
    public void whenCollect() {
        Integer[][] matrix = {{1, 2}, {3, 4}};
        List<Integer> expected = List.of(1, 2, 3, 4);
        FlatMapUsage flatMapUsage = new FlatMapUsage();
        List<Integer> rsl = flatMapUsage.collect(matrix);
        assertThat(rsl, is(expected));
    }
}