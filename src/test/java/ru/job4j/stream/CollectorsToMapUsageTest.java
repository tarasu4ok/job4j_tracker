package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CollectorsToMapUsageTest {
    @Test
    public void whenCollect() {
        List<Student> students = List.of(
                new Student(10, "Surname1"),
                new Student(40, "Surname4"),
                new Student(50, "Surname5"),
                new Student(40, "Surname4"),
                new Student(70, "Surname7"),
                new Student(90, "Surname9"),
                new Student(50, "Surname4")
        );
        CollectorsToMapUsage mapUsage = new CollectorsToMapUsage();
        Map<String, Student> rsl = mapUsage.collect(students);
        Map<String, Student> expected = new HashMap<>();
        Student student = new Student(10, "Surname1");
        expected.put(student.getSurname(), student);
        student = new Student(40, "Surname4");
        expected.put(student.getSurname(), student);
        student = new Student(50, "Surname5");
        expected.put(student.getSurname(), student);
        student = new Student(70, "Surname7");
        expected.put(student.getSurname(), student);
        student = new Student(90, "Surname9");
        expected.put(student.getSurname(), student);
        assertThat(rsl, is(expected));
    }

}