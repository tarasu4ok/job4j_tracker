package ru.job4j.collection;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

public class FreezeStrTest {

    @Test
    public void whenEq() {
        assertThat(FreezeStr.eq("Hello", "Hlloe"), is(true));
    }

    @Test
    public void whenEqBigStrings() {
        assertThat(FreezeStr.eq("А роза упала на лапу Азора",
                "Узор запал пара луна о а а а"), is(true));
    }

    @Test
    public void whenNotEq() {
        assertThat(FreezeStr.eq("Hello", "Halle"), is(false));
    }

    @Test
    public void whenNotMultiEq() {
        assertThat(FreezeStr.eq("heloo", "hello"), is(false));
    }

    @Test
    public void whenNotEqBigStrings() {
        assertThat(FreezeStr.eq("А роза упала на лапу Азора",
                "Узор запал пара луна а а a"), is(false));
    }
}