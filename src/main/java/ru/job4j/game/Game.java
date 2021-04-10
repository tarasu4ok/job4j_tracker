package ru.job4j.game;

import ru.job4j.tracker.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
    public static final Random RANDOM = new Random();
    private final int fullHealthHp = 100;
    private final Power defaultPower = Power.REGULAR;
    private List<Troop> teams;
    private int stepsCount;

    private void createNewTeams() {
        Troop troopA = new Troop(Race.getRandomRace());
        Troop troopB = new Troop(Race.getRandomOppositeRace(troopA.getRace()));
        Character character = new Character(defaultPower, fullHealthHp, Specialization.WIZARD, 1);
        troopA.addActiveCharacter(character);
        character = new Character(defaultPower, fullHealthHp, Specialization.WIZARD, 1);
        troopB.addActiveCharacter(character);
        for (int i = 1; i <= 3; i++) {
            character = new Character(defaultPower, fullHealthHp, Specialization.ARCHER, i);
            troopA.addActiveCharacter(character);
            troopA.addNotMagicCharacter(character);
            character = new Character(defaultPower, fullHealthHp, Specialization.ARCHER, i);
            troopB.addActiveCharacter(character);
            troopB.addNotMagicCharacter(character);
        }
        for (int i = 1; i <= 4; i++) {
            character = new Character(defaultPower, fullHealthHp, Specialization.FIGHTER, i);
            troopA.addActiveCharacter(character);
            troopA.addNotMagicCharacter(character);
            character = new Character(defaultPower, fullHealthHp, Specialization.FIGHTER, i);
            troopB.addActiveCharacter(character);
            troopB.addNotMagicCharacter(character);
        }
        teams = new ArrayList<>();
        teams.add(troopA);
        teams.add(troopB);
    }

    public void init(Input input, List<UserAction> actions) {
        createNewTeams();
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            switch (select) {
                case 1:
                    makeOneStep(teams.get(0), teams.get(1));
                    makeOneStep(teams.get(1), teams.get(0));
                    break;
                case 2:
                    playAllGame(teams.get(0), teams.get(1));
                    break;
                case 3:
                    showResults(teams.get(0), teams.get(1));
                    break;
                case 4:
                    createNewTeams();
                    break;
                case 0:
                    run = false;
                    break;
                default:
                    break;
            }
        }
    }

    private void showResults(Troop troopA, Troop troopB) {
        System.out.println("========== РЕЗУЛЬТАТЫ ==========");
        double totalHp = 0;
        System.out.println("===== [" + troopA.getRace().getName() + "] =====");
        for (Character character : troopA.getActiveCharacters()) {
            System.out.println(character.getSpecialization().getName() + ": "
                    + character.getLifeHp());
            totalHp += character.getLifeHp();
        }
        System.out.println("Total HP: " + totalHp);
        totalHp = 0;
        System.out.println("===== [" + troopB.getRace().getName() + "] =====");
        for (Character character : troopB.getActiveCharacters()) {
            System.out.println(character.getSpecialization().getName() + ": "
                    + character.getLifeHp());
            totalHp += character.getLifeHp();
        }
        System.out.println("Total HP: " + totalHp);
        System.out.println("Общее количество ходов: " + stepsCount);
    }

    private void playAllGame(Troop troopA, Troop troopB) {
        boolean run = true;
        while (run) {
            run = makeOneStep(troopA, troopB);
            if (run) {
                run = makeOneStep(troopB, troopA);
            }
        }
    }

    private boolean makeOneStep(Troop activeTroop, Troop enemyTroop) {
        stepsCount++;
        CharacterAction action = null;
        Character characterForAction;
        if (activeTroop.getStrongCharacter() != null) {
            characterForAction = activeTroop.getStrongCharacter();
            activeTroop.setStrongCharacter(null);
        } else {
            int randomIndex = RANDOM.nextInt(activeTroop.getActiveCharacters().size());
            characterForAction = activeTroop.getActiveCharacters().get(randomIndex);
        }
        switch (characterForAction.getSpecialization()) {
            case WIZARD:
                action = new WizardAction();
                break;
            case ARCHER:
                action = new ArcherAction();
                break;
            case FIGHTER:
                action = new FighterAction();
                break;
            default:
                break;
        }
        int randomAction = RANDOM.nextInt(2) + 1;
        if (Specialization.FIGHTER.equals(characterForAction.getSpecialization())
                || randomAction == 1) {
            action.firstAction(characterForAction, activeTroop, enemyTroop);
        } else {
            action.secondAction(characterForAction, activeTroop, enemyTroop);
        }
        if (enemyTroop.getActiveCharacters().size() == 0) {
            System.out.println("В отряде расы [" + enemyTroop.getRace().getName()
                    + "] не осталось живых персонажей");
            System.out.println("Победила раса [" + activeTroop.getRace().getName() + "]");
            showResults(activeTroop, enemyTroop);
            return false;
        }
        return true;
    }

    private void showMenu(List<UserAction> actions) {
        System.out.println("Menu.");
        System.out.println("0. Exit");
        System.out.println("1. Make one step");
        System.out.println("2. Play all game");
        System.out.println("3. Show current results");
        System.out.println("4. Create new teams");
    }

    public List<Troop> getTeams() {
        return teams;
    }

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(output, new ConsoleInput());
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ExitAction());
        new Game().init(input, actions);
    }
}
