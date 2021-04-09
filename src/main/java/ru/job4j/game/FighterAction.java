package ru.job4j.game;

public class FighterAction implements CharacterAction {
    @Override
    public void firstAction(Character character, Troop activeTroop, Troop enemyTroop) {
        double hp;
        String actionCharacter = "[" + activeTroop.getRace().getName() + "]["
                + character.getSpecialization().getName() + "][" + character.getIndex() + "]";
        String actionName = "\uD83E\uDD1C";
        switch (activeTroop.getRace()) {
            case ELF:
                hp = 15;
                break;
            case HUMAN:
            case UNDEAD:
                hp = 18;
                break;
            case ORK:
                hp = 20;
                break;
            default:
                hp = 0;
                break;
        }
        character.makeHitOrShoot(hp, enemyTroop, actionCharacter, actionName);
    }

    @Override
    public void secondAction(Character character, Troop activeTroop, Troop enemyTroop) {
    }
}