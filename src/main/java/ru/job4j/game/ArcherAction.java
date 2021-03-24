package ru.job4j.game;

public class ArcherAction implements CharacterAction {
    @Override
    public void firstAction(Character character, Troop activeTroop, Troop enemyTroop) {
        double hp = 0;
        String actionCharacter = "[" + activeTroop.getRace().getName() + "]["
                + character.getSpecialization().getName() + "][" + character.getIndex() + "]";
        String actionName = "\uD83C\uDFF9";
        switch (activeTroop.getRace()) {
            case ELF -> hp = 7;
            case HUMAN -> hp = 5;
            case ORK -> hp = 3;
            case UNDEAD -> hp = 4;
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
            case ELF, HUMAN -> hp = 3;
            case ORK -> hp = 2;
            case UNDEAD -> hp = 4;
            default -> hp = 0;
        }
        character.makeHitOrShoot(hp, enemyTroop, actionCharacter, actionName);
    }
}
