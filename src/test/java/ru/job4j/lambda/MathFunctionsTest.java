package ru.job4j.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MathFunctionsTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = MathFunctions.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadraticFunctionThenLinearResults() {
        List<Double> result = MathFunctions.diapason(0, 3, x -> 5 * x * x + 3 * x + 1);
        List<Double> expected = Arrays.asList(1D, 9D, 27D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenExponentialFunctionThenLinearResults() {
        List<Double> result = MathFunctions.diapason(0, 4, x -> Math.pow(5, x));
        List<Double> expected = Arrays.asList(1D, 5D, 25D, 125D);
        assertThat(result, is(expected));
    }
}