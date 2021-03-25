package ru.job4j.game;

import java.util.ArrayList;
import java.util.List;

public class Troop {
    private Race race; // 1 - эльф, 2 - человек, 3 - орк, 4 - нежить
    private List<Character> activeCharacters = new ArrayList<>();
    private List<Character> activeNotMagicCharacters = new ArrayList<>();
    private Character strongCharacter;

    public Troop(Race race) {
        this.race = race;
    }

    public Race getRace() {
        return race;
    }

    public void addActiveCharacter(Character character) {
        activeCharacters.add(character);
    }

    public void removeActiveCharacter(Character character) {
        activeCharacters.remove(character);
    }

    public void addNotMagicCharacter(Character character) {
        activeNotMagicCharacters.add(character);
    }

    public void removeActiveNotMagicCharacter(Character character) {
        activeNotMagicCharacters.remove(character);
    }

    public List<Character> getActiveCharacters() {
        return activeCharacters;
    }

    public List<Character> getActiveNotMagicCharacters() {
        return activeNotMagicCharacters;
    }

    public Character getStrongCharacter() {
        return strongCharacter;
    }

    public void setStrongCharacter(Character strongCharacter) {
        this.strongCharacter = strongCharacter;
    }

    public double getTroopHp() {
        int totalHp = 0;
        for (Character character: this.getActiveCharacters()) {
            totalHp += character.getLifeHp();
        }
        return totalHp;
    }
}