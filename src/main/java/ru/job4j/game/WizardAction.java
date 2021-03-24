package ru.job4j.game;

public class WizardAction implements CharacterAction {
    @Override
    public void firstAction(Character character, Troop activeTroop, Troop enemyTroop) {
        String actionCharacter = "[" + activeTroop.getRace().getName() + "]["
                + character.getSpecialization().getName() + "][" + character.getIndex() + "]";
        String actionName = "";
        switch (activeTroop.getRace()) {
            case ELF, HUMAN, ORK -> {
                actionName += "накладывает улучшение на";
                character.makeTeammateStrong(activeTroop, actionCharacter, actionName);
            }
            case UNDEAD -> {
                actionName += "насылает недуг на";
                character.makeEnemyWeak(enemyTroop, actionCharacter, actionName);
            }
        }
    }

    @Override
    public void secondAction(Character character, Troop activeTroop, Troop enemyTroop) {
        double hp;
        String actionCharacter = "[" + activeTroop.getRace().getName() + "]["
                + character.getSpecialization().getName() + "][" + character.getIndex() + "]";
        String actionName = "";
        switch (activeTroop.getRace()) {
            case ELF -> {
                hp = 10;
                actionName += "\uD83D\uDCAB";
                character.makeHitOrShoot(hp, enemyTroop, actionCharacter, actionName);
            }
            case HUMAN -> {
                hp = 4;
                actionName += "\uD83D\uDCAB";
                character.makeHitOrShoot(hp, enemyTroop, actionCharacter, actionName);
            }
            case ORK -> {
                actionName += "накладывает проклятие на";
                character.makeEnemyNotStrong(enemyTroop, actionCharacter, actionName);
            }
            case UNDEAD -> {
                hp = 5;
                actionName += "\uD83D\uDCAB";
                character.makeHitOrShoot(hp, enemyTroop, actionCharacter, actionName);
            }
        }
    }
}
