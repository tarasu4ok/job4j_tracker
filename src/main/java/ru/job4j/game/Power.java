package ru.job4j.game;

public enum Power {
    WEAK("Ослабленный"),
    REGULAR("Обычный"),
    STRONG("Усиленный");

    private final String name;

    Power(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
