package ru.job4j.oop;

import java.util.Date;

public class Engineer extends Profession{
    private byte category;

    public Engineer(String name, String surname, String education, Date birthday, byte category) {
        super(name, surname, education, birthday);
        this.category = category;
    }

    public byte getCategory() {
        return category;
    }
}
