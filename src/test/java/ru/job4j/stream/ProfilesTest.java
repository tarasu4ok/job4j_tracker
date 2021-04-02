package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ProfilesTest {
    @Test
    public void whenCollectDifferentAddresses() {
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

    @Test
    public void whenCollectSamesAddresses() {
        List<Profile> profiles = List.of(
                new Profile(new Address("Moscow", "Myasnickaya", 12, 55)),
                new Profile(new Address("St Petersburg", "Leningradskaya", 33, 72)),
                new Profile(new Address("Kazan", "Tatarskaya", 2, 36)),
                new Profile(new Address("Kazan", "Nikolskaya", 72, 33)),
                new Profile(new Address("Moscow", "Myasnickaya", 12, 55)),
                new Profile(new Address("Kazan", "Nikolskaya", 65, 17))
        );
        Profiles pr = new Profiles();
        List<Address> rsl = pr.collectWithDistinctAndSort(profiles);
        List<Address> expected = new ArrayList<>();
        expected.add(new Address("Kazan", "Nikolskaya", 65, 17));
        expected.add(new Address("Kazan", "Nikolskaya", 72, 33));
        expected.add(new Address("Kazan", "Tatarskaya", 2, 36));
        expected.add(new Address("Moscow", "Myasnickaya", 12, 55));
        expected.add(new Address("St Petersburg", "Leningradskaya", 33, 72));
        assertThat(rsl, is(expected));
    }
}