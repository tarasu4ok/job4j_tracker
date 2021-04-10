package ru.job4j.game;

public class ArcherAction implements CharacterAction {
    @Override
    public void firstAction(Character character, Troop activeTroop, Troop enemyTroop) {
        double hp = 0;
        String actionCharacter = "[" + activeTroop.getRace().getName() + "]["
                + character.getSpecialization().getName() + "][" + character.getIndex() + "]";
        String actionName = "\uD83C\uDFF9";
        switch (activeTroop.getRace()) {
            case ELF:
                hp = 7;
                break;
            case HUMAN:
                hp = 5;
                break;
            case ORK:
                hp = 3;
                break;
            case UNDEAD:
                hp = 4;
                break;
            default:
                break;
        }
        character.makeHitOrShoot(hp, enemyTroop, actionCharacter, actionName);
    }

    @Override
    public void secondAction(Character character, Troop activeTroop, Troop enemyTroop) {
        double hp;
        String actionCharacter = "[" + activeTroop.getRace().getName() + "]["
                + character.getSpecialization().getName() + "][" + character.getIndex() + "]";
        String actionName = "\uD83E\uDD1C";
        switch (activeTroop.getRace()) {
            case ELF:
            case HUMAN:
                hp = 3;
                break;
            case ORK:
                hp = 2;
                break;
            case UNDEAD:
                hp = 4;
                break;
            default:
                hp = 0;
                break;
        }
        character.makeHitOrShoot(hp, enemyTroop, actionCharacter, actionName);
    }
}
