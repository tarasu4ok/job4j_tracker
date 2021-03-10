package ru.job4j.ex;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class FactTest {

    @Test(expected = IllegalArgumentException.class)
    public void whenNegative() {
        Fact.calc(-10);
    }

    @Test
    public void whenPositive() {
        int rsl = Fact.calc(4);
        assertThat(rsl, is(24));
    }

    @Test
    public void whenZero() {
        int rsl = Fact.calc(0);
        assertThat(rsl, is(1));
    }

}