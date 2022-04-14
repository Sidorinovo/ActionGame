package ActionGame.Weapons;

public abstract class BaseWeapon implements Weapon {
    private final int attack;
    private int durability;
    private boolean isBroken;

    protected BaseWeapon(int attack, int durability){
        this.attack = attack;
        this.durability = durability;
        isBroken = false;
    }

    public int attack(){
        if(this.isBroken){
            throw new IllegalStateException("Weapon is broken");
        }
        this.durabilityDecrease(1);
        return this.attack;
    }

    public int getAttack() {
        return attack;
    }

    protected void durabilityDecrease(int amount){
        this.durability = this.durability - amount;
        if(this.durability <= 0){
            this.isBroken = true;
        }
    }

    protected boolean isBroken(){
        return this.isBroken;
    }
}
