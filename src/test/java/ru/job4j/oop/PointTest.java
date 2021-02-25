package ru.job4j.oop;

import junit.framework.TestCase;

import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PointTest extends TestCase {

    public void testDistance1() {
        Point a = new Point(0, 0);
        Point b = new Point(0, 2);
        double rsl = a.distance(b);
        assertThat(rsl, is(2.0));
    }

    public void testDistance2() {
        Point a = new Point(5, 0);
        Point b = new Point(0, 0);
        double rsl = a.distance(b);
        assertThat(rsl, is(5.0));
    }

    public void testDistance3() {
        Point a = new Point(0, 0);
        Point b = new Point(3, 3);
        double rsl = a.distance(b);
        assertThat(rsl, closeTo(4.24, 0.01));
    }
}