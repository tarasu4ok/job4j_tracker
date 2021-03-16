package ru.job4j.oop.inheritance;

import java.util.Date;

public class Surgeon extends Doctor {
    private String specialization;

    public Surgeon(String name, String surname, String education, Date birthday,
                   String category, String specialization) {
        super(name, surname, education, birthday, category);
        this.specialization = specialization;
    }

    public String getSpecialization() {
        return specialization;
    }
}
