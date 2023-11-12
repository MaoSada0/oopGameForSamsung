package Units;

public class Summoner extends Unit {

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

    public Summoner(String name) {
        super(name);
        this.setHealth(10);
        this.setPower(1);
        this.setCriticalHit(0.1);
        this.setParryChance(0.7);
    }

    @Override
    public int getPower() {

        int power = super.getPower();

        if(mana <= 0){
            return 0;
        }

        if(mana - manaCost <= 0) {
            if (mana <= 10){
                power = power * 2;
            }
            else {
                power = power * (mana + 10) / 10;
            }
            manaCost = mana;
        }
        else if (manaCost <= 10){
            power = power * 2;
        }
        else {
            power = power * (manaCost + 10) / 10;
        }
        mana = mana - manaCost;


        return super.getPower();
    }


    @Override
    public String toString() {
        return "Summoner{" +
                "name='" + name + '\'' +
                ", power=" + power +
                ", health=" + health +
                ", stamina=" + stamina +
                ", armor=" + armor +
                ", criticalHit=" + criticalHit +
                '}';
    }
}
