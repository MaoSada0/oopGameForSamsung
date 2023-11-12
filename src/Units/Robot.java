package Units;


public class Robot extends Unit {

    public Robot(String name) {
        super(name);
        this.setHealth(700);
        this.setPower(25);
        this.setCriticalHit(0.2);
        this.setParryChance(0.1);
    }

    @Override
    public String toString() {
        return "Robot{" +
                "name='" + name + '\'' +
                ", power=" + power +
                ", health=" + health +
                ", stamina=" + stamina +
                ", armor=" + armor +
                ", criticalHit=" + criticalHit +
                '}';
    }
}
