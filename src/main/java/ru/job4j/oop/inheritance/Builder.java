package ru.job4j.oop.inheritance;

import java.util.Date;

public class Builder extends Engineer {
    private boolean canWorkAtHeight;

    public Builder(String name, String surname, String education, Date birthday, byte category, boolean canWorkAtHeight) {
        super(name, surname, education, birthday, category);
        this.canWorkAtHeight = canWorkAtHeight;
    }

    public boolean isCanWorkAtHeight() {
        return canWorkAtHeight;
    }
}
