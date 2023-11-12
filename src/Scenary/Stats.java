package Scenary;

import Units.Unit;
import main.Player;

import java.util.List;

public class Stats {
    Player player;

    public Stats(Player player) {
        this.player = player;
    }

    public void print(){
        List<Unit> units = player.getCharacters();
        for(Unit x: units){
            System.out.print(x.getName() + " " + x.getHealth() + " ");
        }
    }
}
