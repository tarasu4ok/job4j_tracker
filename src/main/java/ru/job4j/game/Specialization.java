package ru.job4j.game;

public enum Specialization {
    WIZARD("МАГ"),
    ARCHER("ЛУЧНИК"),
    FIGHTER("БОЕЦ");

    private final String name;

    Specialization(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
