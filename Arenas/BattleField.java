package ActionGame.Arenas;

import ActionGame.Players.Enemy;
import ActionGame.Players.Hero;
import ActionGame.Players.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class BattleField {
    private List<Player> heroes;
    private List<Player> enemies;
    private Player hero;
    private Player enemy;

    public void addHero(Hero hero) {
        if (this.heroes == null) {
            this.heroes = new ArrayList<>();
        }
        if (hero.getClass().equals(Hero.class)) {
            this.heroes.add(hero);
        }
    }

    public List<Player> getHeroes() {
        return Collections.unmodifiableList(this.heroes);
    }

    public void setHero(Player hero) {
        if (hero.getClass().equals(Hero.class)) {
            this.hero = hero;
        }
    }

    public void addEnemy(Enemy enemy) {
        if (this.enemies == null) {
            this.enemies = new ArrayList<>();
        }
        if (enemy.getClass().equals(Enemy.class)) {
            this.enemies.add(enemy);
        }
    }

    public List<Player> getEnemies() {
        return Collections.unmodifiableList(this.enemies);
    }

    public void setEnemy(Player enemy) {
        if (enemy.getClass().equals(Enemy.class)) {
            this.enemy = enemy;
        }
    }

    public String startDuel() {

        if(this.hero == null || this.enemy == null){
            throw new IllegalStateException("Player/Players cannot be null.");
        }

        Random rnd = new Random();
        int whoWillStartFirst = rnd.nextInt(999);

        String result;

        if (whoWillStartFirst % 2 == 0) {
            result = heroStarts();
        } else {
            result = enemyStarts();
        }

        return result;
    }

    private String heroStarts() {
        while (this.hero.isAlive() && this.enemy.isAlive()) {
            System.out.println(this.hero.attack(this.enemy));
            if (this.enemy.isAlive()) {
                System.out.println(this.enemy.attack(this.hero));
            }
        }
        if (hero.isAlive()) {
            return String.format("Player: %s with name %s has won the match", this.hero.getClass().getSimpleName(), this.hero.getName());
        }
        return String.format("Player: %s with name %s has won the match", this.enemy.getClass().getSimpleName(), this.enemy.getName());
    }

    private String enemyStarts() {
        while (this.hero.isAlive() && this.enemy.isAlive()) {
            System.out.println(this.enemy.attack(this.hero));
            if (this.hero.isAlive()) {
                System.out.println(this.hero.attack(this.enemy));
            }
        }
        if (hero.isAlive()) {
            return String.format("Player: %s with name %s has won the match", this.hero.getClass().getSimpleName(), this.hero.getName());
        }
        return String.format("Player: %s with name %s has won the match", this.enemy.getClass().getSimpleName(), this.enemy.getName());
    }
}
