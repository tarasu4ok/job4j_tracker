package ru.job4j.game;

public interface CharacterAction {
    void firstAction(Character character, Troop activeTroop, Troop enemyTroop);

    void secondAction(Character character, Troop activeTroop, Troop enemyTroop);
}
