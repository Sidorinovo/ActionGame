package ActionGame.Players;

import ActionGame.Weapons.Weapon;

public class Hero extends BasePlayer {

    public Hero(String name, int health, int armor, int damage, Weapon weapon) {
        super(name, health, armor, damage, weapon);
    }

    @Override
    public String attack(Player player) {
        if (!this.isAlive()) {
            throw new IllegalStateException("Hero is dead.");
        }

        int damage = this.getWeapon().attack() + this.getDamage();
        player.takeDamage(damage);

        StringBuilder result = new StringBuilder().append(String.format("Enemy was hit for %d points.", damage));

        if (!player.isAlive()) {
            result.append(System.lineSeparator());
            result.append("Enemy has died.");
        }

        return result.toString();
    }
}
