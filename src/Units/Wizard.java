package Units;

public class Wizard extends Unit {

    private int mana = 100;
    private int manaCost;

    public void setManaCost(int manaCost) {
        this.manaCost = manaCost;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public Wizard(String name) {
        super(name);
        this.setHealth(150);
        this.setPower(25);
        this.setCriticalHit(0.2);
        this.setParryChance(0.1);
    }

    @Override
    public int getPower() {

        int power = super.getPower();

        if(mana <= 0){
            return 0;
        }

        if(mana - manaCost <= 0) {
            power = power * ((mana / 10) + 1);
            manaCost = mana;
        }
        else {
            power = power * ((manaCost / 10) + 1);
        }
        mana = mana - manaCost;


        return power;
    }

    @Override
    public String toString() {
        return "Wizard{" +
                "name='" + name + '\'' +
                ", power=" + power +
                ", health=" + health +
                ", stamina=" + stamina +
                ", armor=" + armor +
                ", criticalHit=" + criticalHit +
                '}';
    }
}
