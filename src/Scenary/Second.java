package Scenary;

import Units.*;
import main.Player;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Second {

    First first = new First();
    static Player player1 = First.temp.player1;
    static Player player2 = First.temp.player2;
    static Stats stats1 = new Stats(player1);
    static Stats stats2 = new Stats(player2);
    static List<Unit> characters1 = player1.getCharacters();
    static List<Unit> characters2 = player2.getCharacters();
    int healthPlayer1 = player1.getTotalHealth();
    int healthPlayer2 = player2.getTotalHealth();
    static boolean crit = false;
    static int manaPlus = 15;

    static int manaCost;

    public void second(){
        int k = 0;

        while(true){
            if(characters1.isEmpty()){
                System.out.println("p1 проиграл");
                break;
            }
            if(characters2.isEmpty()){
                System.out.println("p2 проиграл");
                break;
            }
            if(k % 2 == 0) {
                attackP1();
            }
            else {
                attackP2();
            }
            k++;
            System.out.println();
        }

    }

    static int damage = 0;

    public static void whoAttackP1(String ch){
        for(Unit x: characters1){
            if(x.getName().equals(ch)){
                if(ch.equals("W")){
                    ((Wizard) x).setManaCost(manaCost);
                }
                if(ch.equals("S")){
                    ((Summoner) x).setManaCost(manaCost);
                }
                damage = x.getPower();
                crit = x.isWasCriticalHit();
            }
        }
    }

    public static void toAttackP1(String ch){
        Boolean flag = false;
        Unit temp = new Unit("1");

        for(Unit x: characters2){
            if(x.getName().equals(ch)){
                if(x.isWasParryHit()){
                    System.out.print("Parry!");
                }
                else {
                    if (x.getHealth() - damage > 0) {
                        if (crit) {
                            System.out.println("Critical!");
                        }
                        x.setHealth(x.getHealth() - damage);
                        System.out.print(x.getName() + " " + x.getHealth());
                    } else {
                        flag = true;
                        temp = x;
                    }
                }
            }
        }
        if(flag){
            System.out.println(temp.getName() + " умер");
            characters2.remove(temp);
            flag = false;
        }
    }

    public static void attackP1(){
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println("p1: Выбери персонажа, которым будешь атаковать: ");
        System.out.print("| ");
        for(Unit x: characters1){
            if (x instanceof Wizard){
                System.out.print(x.getName() + "(hp: " + x.getHealth() + ")" + "(mana: " + ((Wizard) x).getMana() + ")" + " | ");
                ((Wizard) x).setMana(((Wizard) x).getMana() + manaPlus);
                continue;
            }
            if(x instanceof Summoner){
                System.out.print(x.getName() + "(hp: " + x.getHealth() + ")" + "(mana: " +  ((Summoner) x).getMana() + ")" + " | ");
                ((Summoner)x).setMana(((Summoner)x).getMana() + 1);
                continue;
            }
            System.out.print(x.getName() + "(hp: " + x.getHealth() + ")" + " | ");
        }
        System.out.println();
        //stats1.print();
        String unitWhoAttack = sc.nextLine();

        switch (unitWhoAttack){
            case "N":
                whoAttackP1("N");
                break;
            case "K":
                whoAttackP1("K");
                break;
            case "W":
                System.out.print("mana: ");
                manaCost = sc.nextInt();
                sc.nextLine();
                whoAttackP1("W");
                break;
            case "R":
                whoAttackP1("R");
                break;
            /*case "S":
                System.out.print("mana: ");
                manaCost = sc.nextInt();
                sc.nextLine();
                whoAttackP1("S");
                break;*/
        }

        System.out.println();
        System.out.println("Выбери персонажа, которого будешь атаковать: ");
        System.out.print("| ");
        for(Unit x: characters2){
            System.out.print(x.getName() + " | ");
        }
        String unitToAttack = sc.nextLine();


        switch (unitToAttack){
            case "N":
                toAttackP1("N");
                break;
            case "K":
                toAttackP1("K");
                break;
            case "W":
                toAttackP1("W");
                break;
            case "R":
                toAttackP1("R");
                break;
            /*case "S":
                toAttackP1("S");
                break;*/
        }
    }

    public static void whoAttackP2(String ch){
        for(Unit x: characters2){
            if(x.getName().equals(ch)){
                if(ch.equals("W")){
                    ((Wizard) x).setManaCost(manaCost);
                }
                if(ch.equals("S")){
                    ((Summoner) x).setManaCost(manaCost);
                }
                damage = x.getPower();
                crit = x.isWasCriticalHit();
            }
        }
    }

    public static void toAttackP2(String ch){
        Boolean flag = false;
        Unit temp = new Unit("1");

        for(Unit x: characters1){
            if(x.getName().equals(ch)){
                if(x.isWasParryHit()){
                    System.out.print("Parry!");
                }
                else {
                    if (x.getHealth() - damage > 0) {
                        if (crit) {
                            System.out.println("Critical!");
                        }
                        x.setHealth(x.getHealth() - damage);
                        System.out.print(x.getName() + " " + x.getHealth());
                    } else {
                        flag = true;
                        temp = x;
                    }
                }
            }
        }
        if(flag){
            System.out.println(temp.getName() + " умер");
            characters1.remove(temp);
            flag = false;
        }
    }

    public static void attackP2(){
        Scanner sc = new Scanner(System.in);
        int damage = 0;
        System.out.println();

        System.out.println("p2: Выбери персонажа, которым будешь атаковать: ");
        System.out.print("| ");
        for(Unit x: characters2){
            if (x instanceof Wizard){
                System.out.print(x.getName() + "(hp: " + x.getHealth() + ")" + "(mana: " + ((Wizard) x).getMana() + ")" + " | ");
                ((Wizard) x).setMana(((Wizard) x).getMana() + manaPlus);
                continue;
            }
            if(x instanceof Summoner){
                System.out.print(x.getName() + "(hp: " + x.getHealth() + ")" + "(mana: " +  ((Summoner) x).getMana() + ")" + " | ");
                ((Summoner)x).setMana(((Summoner)x).getMana() + 1);
                continue;
            }
            System.out.print(x.getName() + "(hp: " + x.getHealth() + ")" + " | ");
        }
        System.out.println();
        //stats2.print();
        Boolean flag = false;
        Unit temp = new Unit("1");

        String unitWhoAttack = sc.nextLine();

        switch (unitWhoAttack){
            case "N":
                whoAttackP2("N");
                break;
            case "K":
                whoAttackP2("K");
                break;
            case "W":
                System.out.print("mana: ");
                manaCost = sc.nextInt();
                sc.nextLine();
                whoAttackP2("W");
                break;
            case "R":
                whoAttackP2("R");
                break;
            /*case "S":
                System.out.print("mana: ");
                manaCost = sc.nextInt();
                sc.nextLine();
                whoAttackP2("S");
                break;*/
        }
        System.out.println();
        System.out.println("Выбери персонажа, которого будешь атаковать: ");
        System.out.print("| ");
        for(Unit x: characters1){
            System.out.print(x.getName() + " | ");
        }
        String unitToAttack = sc.nextLine();

        switch (unitToAttack){
            case "N":
                toAttackP2("N");
                break;
            case "K":
                toAttackP2("K");
                break;
            case "W":
                toAttackP2("W");
                break;
            case "R":
                toAttackP2("R");
                break;
            /*case "S":
                toAttackP2("S");
                break;*/
        }
    }
}
