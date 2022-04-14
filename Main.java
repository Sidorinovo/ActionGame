package ActionGame;

import ActionGame.Arenas.BattleField;
import ActionGame.Players.Enemy;
import ActionGame.Players.Hero;
import ActionGame.Players.Player;
import ActionGame.Weapons.Axe;
import ActionGame.Weapons.Sword;

public class Main {
    public static void main(String[] args) {
        Player hero = new Hero("Sido", 100, 100, 13, new Axe(13, 10));
        Player enemy = new Enemy("Dark Sido", 100, 100, 13, new Axe(13, 10));

        BattleField battleField = new BattleField();

        battleField.setEnemy(enemy);
        battleField.setHero(hero);

        System.out.println(battleField.startDuel());

        battleField.addHero(new Hero("Ivan The Great", 1000, 2000, 100, new Axe(100, 10000)));
        battleField.addHero(new Hero("Tiny", 50, 25, 12, new Sword(7, 5)));
        battleField.addHero(new Hero("Pinky", 90, 45, 23, new Sword(14, 60)));

        battleField.addEnemy(new Enemy("Petko Ludia", 500, 400, 130, new Axe(130, 8000)));
        battleField.addEnemy(new Enemy("Sasho Zviara", 120, 65, 32, new Sword(14, 23)));
        battleField.addEnemy(new Enemy("Grozdan", 50, 40, 3, new Axe(6, 3)));

        battleField.setHero(battleField.getHeroes().get(0));
        battleField.setEnemy(battleField.getEnemies().get(0));

        System.out.println(battleField.startDuel());
    }
}
