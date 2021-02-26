package ru.job4j.oop.inheritance;

import java.util.Date;

public class Doctor extends Profession {
    private String category;

    public Doctor(String name, String surname, String education, Date birthday, String category) {
        super(name, surname, education, birthday);
        this.category = category;
    }

    public String getCategory() {
        return category;
    }
}
