package main;

import Units.Unit;

import java.util.ArrayList;
import java.util.List;

public class Player {

    int totalHealth = 0;

    public int getTotalHealth() {
        return totalHealth;
    }

    private List<Unit> characters;

    public Player() {;
        this.characters = new ArrayList<>();
    }

    public List<Unit> getCharacters() {
        return characters;
    }

    public void addCharacter(Unit character) {
        characters.add(character);
        totalHealth = totalHealth + character.getHealth();
    }

    @Override
    public String toString() {
        return "Player{" +
                "characters=" + characters +
                '}';
    }
}
