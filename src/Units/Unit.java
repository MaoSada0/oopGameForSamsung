package Units;
import java.util.concurrent.ThreadLocalRandom;

public class Unit {



    protected String name;

    protected int power;
    protected int health;
    protected int stamina;
    protected int armor;
    protected double criticalHit;
    protected double parryChance;
    protected boolean wasCriticalHit = false;
    protected boolean wasParryHit;



    public boolean isWasParryHit() {
        double randomNum = ThreadLocalRandom.current().nextDouble(0, 1);
        if(randomNum < parryChance){
            return true;
        }
        else {
            return false;
        }
    }

    public double getParryChance() {
        return parryChance;
    }

    public void setParryChance(double parryChance) {
        this.parryChance = parryChance;
    }

    public void setWasParryHit(boolean wasParryHit) {
        this.wasParryHit = wasParryHit;
    }

    public Unit(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public boolean isWasCriticalHit() {
        return wasCriticalHit;
    }

    public int getPower() {
        wasCriticalHit = false;
        double randomNum = ThreadLocalRandom.current().nextDouble(0, 1);

        if(randomNum < criticalHit){
            int newPower = power * 2;
            wasCriticalHit = true;
            return newPower;
        }

        return power;
    }


    public void setPower(int power) {

        this.power = power;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public double getCriticalHit() {
        return criticalHit;
    }

    public void setCriticalHit(double criticalHit) {
        this.criticalHit = criticalHit;
    }

}
