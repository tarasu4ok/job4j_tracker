package ru.job4j.game;

import java.util.Random;

public enum Race {
    ELF("ЭЛЬФЫ"),
    HUMAN("ЛЮДИ"),
    ORK("ОРКИ"),
    UNDEAD("НЕЖИТЬ");

    private final String name;

    Race(String name) {
        this.name = name;
    }

    public static Race getRandomRace() {
        return Race.values()[Game.RANDOM.nextInt(Race.values().length)];
    }

    public static Race getRandomOppositeRace(Race race) {
        if (ELF.equals(race) || HUMAN.equals(race)) {
            return Race.values()[Game.RANDOM.nextInt(2) + 2];
        } else {
            return Race.values()[Game.RANDOM.nextInt(2)];
        }
    }

    public String getName() {
        return name;
    }
}