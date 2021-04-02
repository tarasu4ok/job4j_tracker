package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ProfilesTest {
    @Test
    public void whenCollectClassA() {
        List<Profile> profiles = List.of(
                new Profile(new Address("Moscow", "Myasnickaya", 12, 55)),
                new Profile(new Address("St Petersburg", "Leningradskaya", 33, 72)),
                new Profile(new Address("Kazan", "Tatarskaya", 2, 36))
        );
        Profiles pr = new Profiles();
        List<Address> rsl = pr.collect(profiles);
        List<Address> expected = new ArrayList<>();
        expected.add(new Address("Moscow", "Myasnickaya", 12, 55));
        expected.add(new Address("St Petersburg", "Leningradskaya", 33, 72));
        expected.add(new Address("Kazan", "Tatarskaya", 2, 36));
        assertThat(rsl, is(expected));
    }
}