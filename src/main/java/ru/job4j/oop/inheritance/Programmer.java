package ru.job4j.oop.inheritance;

import java.util.Date;

public class Programmer extends Engineer {
    private String level;

    public Programmer(String name, String surname, String education, Date birthday,
                      byte category, String level) {
        super(name, surname, education, birthday, category);
        this.level = level;
    }

    public String getLevel() {
        return level;
    }
}
