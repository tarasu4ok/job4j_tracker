package ru.job4j.oop.inheritance;

import java.util.Date;

public class Dentist extends Doctor {
    private boolean canUseMicroscope;

    public Dentist(String name, String surname, String education, Date birthday,
                   String category, boolean canUseMicroscope) {
        super(name, surname, education, birthday, category);
        this.canUseMicroscope = canUseMicroscope;
    }

    public boolean isCanUseMicroscope() {
        return canUseMicroscope;
    }
}
