package ru.job4j.game;

import java.util.Random;

public enum Race {
    ELF("ЭЛЬФЫ"),
    HUMAN("ЛЮДИ"),
    ORK("ОРКИ"),
    UNDEAD("НЕЖИТЬ");

    private static final Random random = new Random();
    private final String name;

    Race(String name) {
        this.name = name;
    }

    public static Race getRandomRace() {
        return Race.values()[random.nextInt(Race.values().length)];
    }

    public static Race getRandomOppositeRace(Race race) {
        if (ELF.equals(race) || HUMAN.equals(race)) {
            return Race.values()[random.nextInt(2) + 2];
        } else {
            return Race.values()[random.nextInt(2)];
        }
    }

    public String getName() {
        return name;
    }
}