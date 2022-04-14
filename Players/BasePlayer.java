package ActionGame.Players;

import ActionGame.Weapons.Weapon;

public abstract class BasePlayer implements Player {
    private String name;
    private int health;
    private int armor;
    private int damage;
    private Weapon weapon;
    private boolean isAlive;

    public BasePlayer(String name, int health, int armor, int damage, Weapon weapon) {
        this.setName(name);
        this.setHealth(health);
        this.setArmor(armor);
        this.setDamage(damage);
        this.setWeapon(weapon);
        this.isAlive = true;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or empty.");
        }
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    private void setHealth(int health) {
        if (health <= 0) {
            throw new IllegalArgumentException("Health cannot be zero or negative number.");
        }
        this.health = health;
    }

    public int getArmor() {
        return armor;
    }

    private void setArmor(int armor) {
        if (armor <= 0) {
            throw new IllegalArgumentException("Armor cannot be zero or negative number.");
        }
        this.armor = armor;
    }

    public int getDamage() {
        return damage;
    }

    private void setDamage(int damage) {
        if (damage <= 0) {
            throw new IllegalArgumentException("Damage cannot be zero or negative number.");
        }
        this.damage = damage;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    private void setWeapon(Weapon weapon) {
        if (weapon == null) {
            throw new IllegalArgumentException("Weapon cannot be null.");
        }
        this.weapon = weapon;
    }

    @Override
    public String attack(Player player) {
        if (!this.isAlive) {
            throw new IllegalStateException("Player is dead.");
        }

        int damage = this.weapon.attack() + this.damage;
        player.takeDamage(damage);

        StringBuilder result = new StringBuilder().append(String.format("Enemy was hit for %d points.", damage));

        if (!player.isAlive()) {
            result.append(System.lineSeparator());
            result.append("Enemy has died.");
        }

        return result.toString();
    }

    @Override
    public void takeDamage(int points) {
        if (points >= this.getArmor()) {
            int damage = points - this.getArmor();
            this.armor = 0;
            this.health = this.health - damage;

            if (this.getHealth() <= 0) {
                this.health = 0;
                this.isAlive = false;
            }
        } else {
            this.setArmor(this.getArmor() - points);
        }
    }

    @Override
    public boolean isAlive() {
        return this.isAlive;
    }
}
