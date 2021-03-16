package ru.job4j.collection;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PassportOfficeTest {

    @Test
    public void addCitizenWithDifferentPassport() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        Citizen citizen2 = new Citizen("2f44f", "Taras Kramarenko");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        office.add(citizen2);
        assertThat(office.get(citizen.getPassport()), is(citizen));
        assertThat(office.get(citizen2.getPassport()), is(citizen2));
    }

    @Test
    public void addCitizenWithSamePassport() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        Citizen citizen2 = new Citizen("2f44a", "Taras Kramarenko");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        boolean rsl = office.add(citizen2);
        assertThat(office.get(citizen.getPassport()), is(citizen));
        assertFalse(rsl);
    }
}