package ActionGame.Weapons;

public class Axe extends BaseWeapon {
    public Axe(int attack, int durability) {
        super(attack, durability);
    }

    @Override
    public int attack(){
        if(this.isBroken()){
            throw new IllegalStateException("Weapon is broken");
        }
        this.durabilityDecrease(2);
        return this.getAttack() * 3;
    }
}
