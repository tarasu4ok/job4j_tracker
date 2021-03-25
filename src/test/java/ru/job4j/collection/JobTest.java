package ru.job4j.collection;

import org.junit.Test;

import java.util.Comparator;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.*;

public class JobTest {
    @Test
    public void whenCompatorAscByName() {
        Comparator<Job> comparator = new JobAscByName();
        int rsl = comparator.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenCompatorDescByName() {
        Comparator<Job> comparator = new JobDescByName();
        int rsl = comparator.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompatorAscByPriority() {
        Comparator<Job> comparator = new JobAscByPriority();
        int rsl = comparator.compare(
                new Job("Fix bug", 0),
                new Job("Impl task", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompatorDescByPriority() {
        Comparator<Job> comparator = new JobDescByPriority();
        int rsl = comparator.compare(
                new Job("Fix bug", 0),
                new Job("Impl task", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenCompatorAscByNameAndPrority() {
        Comparator<Job> comparator = new JobAscByPriority()
                .thenComparing(new JobAscByName());
        int rsl = comparator.compare(
                new Job("Fix bug", 1),
                new Job("Impl task", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompatorDescByNameAndPrority() {
        Comparator<Job> comparator = new JobDescByName()
                .thenComparing(new JobDescByPriority());
        int rsl = comparator.compare(
                new Job("Impl task", 1),
                new Job("Impl task", 0)
        );
        assertThat(rsl, lessThan(0));
    }
}