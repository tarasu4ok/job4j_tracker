package ru.job4j.game;

import java.util.ArrayList;
import java.util.List;

public class Character {

    private final Specialization specialization;
    private Power power;
    private double lifeHp;
    private final int index;

    public Character(Power power, double lifeHp, Specialization specialization, int index) {
        this.power = power;
        this.lifeHp = lifeHp;
        this.specialization = specialization;
        this.index = index;
    }

    public Character chooseCharacterForAction(List<Character> troopCharacters) {
        int randomCharacter = Game.RANDOM.nextInt(troopCharacters.size());
        return troopCharacters.get(randomCharacter);
    }

    // наложение улучшения на персонажа своего отряда
    public void makeTeammateStrong(Troop teamTroop, String actionCharacter, String actionName) {
        if (teamTroop.getActiveNotMagicCharacters().size() != 0) {
            Character teammateCharacter =
                    chooseCharacterForAction(teamTroop.getActiveNotMagicCharacters());
            teammateCharacter.setPower(Power.STRONG);
            teamTroop.setStrongCharacter(teammateCharacter);
            System.out.println(actionCharacter + " " + actionName
                    + " [" + teamTroop.getRace().getName() + "]["
                    + teammateCharacter.getSpecialization().getName() + "]["
                    + teammateCharacter.getIndex()
                    + "], своего отряда на один ход");
        } else {
            System.out.println(actionCharacter
                    + " не может наложить улучшение на персонажей своего отряда, "
                    + "поскольку остался один");
        }
    }

    // снятие улучшения с персонажа вражеского отряда
    public void makeEnemyNotStrong(Troop enemyTroop, String actionCharacter, String actionName) {
        Character enemyCharacter = enemyTroop.getStrongCharacter();
        if (enemyCharacter != null) {
            enemyCharacter.setPower(Power.REGULAR);
            enemyTroop.setStrongCharacter(null);
            System.out.println(actionCharacter + " " + actionName + " ["
                    + enemyTroop.getRace().getName() + "]["
                    + enemyCharacter.getSpecialization().getName()
                    + "][" + enemyCharacter.getIndex() + "] вражеского отряда, "
                    + "снимая с него улучшение");
        } else {
            System.out.println(actionCharacter + " не может снять улучшение с "
                    + "персонажей вражеского отряда");
        }
    }

    // наслать недуг (уменьшение силы урона персонажа противника на 50% на один ход)
    public void makeEnemyWeak(Troop enemyTroop, String actionCharacter, String actionName) {
        Character enemyCharacter = chooseCharacterForAction(enemyTroop.getActiveCharacters());
        enemyCharacter.setPower(Power.WEAK);
        System.out.println(actionCharacter + " " + actionName + " ["
                + enemyTroop.getRace().getName() + "]["
                + enemyCharacter.getSpecialization().getName()
                + "][" + enemyCharacter.getIndex() + "], уменьшая на 50% его урон на один ход");
    }

    private double calculateAttackHp(double hp) {
        switch (this.getPower()) {
            case WEAK:
                hp = hp / 2;
                break;
            case STRONG:
                hp = hp * 1.5;
                break;
        }
        this.setPower(Power.REGULAR);
        return hp;
    }

    // нанести урон или выстрелить из лука
    public void makeHitOrShoot(double hp,
                               Troop enemyTroop,
                               String actionCharacter,
                               String actionName) {
        Character enemyCharacter = chooseCharacterForAction(enemyTroop.getActiveCharacters());
        double attackHp = calculateAttackHp(hp);
        double newHealthHp = enemyCharacter.getLifeHp() - attackHp;
        String str = actionCharacter + " " + actionName
                + " [" + enemyTroop.getRace().getName()
                + "][" + enemyCharacter.getSpecialization().getName()
                + "][" + enemyCharacter.getIndex() + "], урон: " + attackHp + " HP";
        if (newHealthHp <= 0) {
            enemyCharacter.setLifeHp(0);
            enemyTroop.removeActiveCharacter(enemyCharacter);
            enemyTroop.removeActiveNotMagicCharacter(enemyCharacter);
            str += " . [" + enemyTroop.getRace().getName() + "]["
                    + enemyCharacter.getSpecialization().getName()
                    + "][" + enemyCharacter.getIndex() + "] \uD83D\uDD46";
        } else {
            enemyCharacter.setLifeHp(newHealthHp);
        }
        System.out.println(str);
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public Power getPower() {
        return power;
    }

    public void setPower(Power power) {
        this.power = power;
    }

    public double getLifeHp() {
        return lifeHp;
    }

    public void setLifeHp(double lifeHp) {
        this.lifeHp = lifeHp;
    }

    public int getIndex() {
        return index;
    }
}
