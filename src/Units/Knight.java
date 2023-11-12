package Units;

public class Knight extends Unit {

    public Knight(String name) {
        super(name);
        this.setHealth(300);
        this.setPower(70);
        this.setCriticalHit(0.3);
        this.setParryChance(0.4);
    }

    @Override
    public String toString() {
        return "Knight{" +
                "name='" + name + '\'' +
                ", power=" + power +
                ", health=" + health +
                ", stamina=" + stamina +
                ", armor=" + armor +
                ", criticalHit=" + criticalHit +
                '}';
    }
}
