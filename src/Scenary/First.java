package Scenary;

import Units.*;
import main.Player;

import java.util.Scanner;

public class First {

    static Temp temp = new Temp();

    public void first(){
        Scanner sc = new Scanner(System.in);
        int x = 0;
        int x1 = 0;
        Player player1 = temp.player1;
        System.out.println("PLAYER 1: ");
        hello();

        boolean flag = true;
        while (true) {
            x = sc.nextInt();
            x1 = x;
            int k = 0;
            while (x > 0) {
                k++;
                int y = x % 10;
                if (!(y == 1 || y == 2 || y == 3 || y == 4)) {
                    System.out.print("Введи норм числа: ");
                    flag = false;
                    break;
                }
                x = x / 10;
            }

            if(k != 2 && flag){
                System.out.print("Введи норм числа: ");
                flag = false;
            }
            if(flag){
                break;
            }
            flag = true;
        }
        player1 = choice(x1, player1);
        temp.setPlayer1(player1);

        load();

        Player player2 = temp.player2;
        System.out.println("PLAYER 2: ");
        hello();

        flag = true;
        while (true) {
            x = sc.nextInt();
            x1 = x;
            int k = 0;
            while (x > 0) {
                k++;
                int y = x % 10;
                if (!(y == 1 || y == 2 || y == 3 || y == 4)) {
                    System.out.print("Введи норм числа: ");
                    flag = false;
                    break;
                }
                x = x / 10;
            }

            if(k != 2 && flag){
                System.out.print("Введи норм числа: ");
                flag = false;
            }
            if(flag){
                break;
            }
            flag = true;
        }

        player2 = choice(x1, player2);
        temp.setPlayer2(player2);

    }

    public static void load(){
        for(int i = 0; i < 21; i++){
            if(i % 2 == 0){
                System.out.print("|");
            }else {
                System.out.print("*");
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
    }

    public static void hello(){
        System.out.println("Выбери 2ух героев:");
        System.out.println("(1) - нинзя");
        System.out.println("(2) - рыцарь");
        System.out.println("(3) - маг");
        System.out.println("(4) - робот");
        /*System.out.println("(5) - призыватель");*/
        System.out.print("Напиши две цифры: ");
    }

    public static Player choice(int num, Player player){
        String name;
        while (num > 0){
            int x = num % 10;
            num = num / 10;
            switch (x){
                case 1:
                    name = "N";
                    player.addCharacter(new Ninja(name));
                    break;
                case 2:
                    name = "K";
                    player.addCharacter(new Knight(name));
                    break;
                case 3:
                    name = "W";
                    player.addCharacter(new Wizard(name));
                    break;
                case 4:
                    name = "R";
                    player.addCharacter(new Robot(name));
                    break;
                /*case 5:
                    name = "S";
                    player.addCharacter(new Summoner(name));
                    break;*/
            }

        }
        return player;
    }

}
