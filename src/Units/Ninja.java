package Units;


public class Ninja extends Unit {


    public Ninja(String name) {
        super(name);
        this.setHealth(230);
        this.setPower(80);
        this.setCriticalHit(0.3);
        this.setParryChance(0.6);
    }

    @Override
    public String toString() {
        return "Archer{" +
                "name='" + name + '\'' +
                ", power=" + power +
                ", health=" + health +
                ", stamina=" + stamina +
                ", armor=" + armor +
                ", criticalHit=" + criticalHit +
                '}';
    }
}
