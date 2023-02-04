package location.safe;

import character.Fighter;
import items.armors.*;
import items.weapons.*;

import java.util.Scanner;

public class Store {

    static int Biggest_WCNL =0;
    static int Biggest_ACNL =0;
    final static Weapon[] subClassesOfWeapon = {new Pistol(), new Sword(), new Gun()};
    final static Armor[] subClassesOfArmor = {new Light(), new Average(), new Heavy()};
   public static void Receive(Fighter player){
       Scanner sc = new Scanner(System.in);
       for (Weapon w : subClassesOfWeapon) {
           if (Biggest_WCNL < w.getClass().getSimpleName().length()) {
               Biggest_WCNL = w.getClass().getSimpleName().length();
           }
       }
       for (Armor a : subClassesOfArmor) {
           if (Biggest_ACNL < a.getClass().getSimpleName().length()) {
               Biggest_ACNL = a.getClass().getSimpleName().length();
           }
       }
        System.out.println("what do you want to buy ?");
        System.out.println("1. Weapon\n2. Armor\n\n3. Quit");

       int answer = Integer.parseInt(sc.nextLine());

       switch (answer){
           case 1 -> buyWeapon(player);
           case 2 -> buyArmor(player);
           default -> System.out.println("you didn't buy anything !");
       }
    }
   static private void buyWeapon(Fighter player){
       Scanner sc = new Scanner(System.in);
       System.out.println("available weapons :\n");
       for (Weapon w : subClassesOfWeapon) {
           System.out.println(w.getId()+". "
                   + w.getClass().getSimpleName()+String.format("%" + ((Biggest_WCNL+1)-w.getClass().getSimpleName().length() )+ "s","")
                   + "=> "
                   + String.format("%" + 15 + "s", " DAMAGE : " + w.getDamage() )
                   + String.format("%" + 15 + "s", "PRICE : " + w.getPrice() ));
       }
       System.out.println("\npress different key to quit");
       String answer = sc.nextLine();
       switch (Integer.parseInt(answer)) {
           case 1 -> {
               if (player.getMoney() >= Pistol.PRICE) {
                   player.setMoney(player.getMoney() - Pistol.PRICE);
                   player.weapon = new Pistol();
                   System.out.println("now you have a Pistol");
               } else {
                   System.out.println("you don't have enough money to buy a Pistol");
               }
           }
           case 2 -> {
               if (player.getMoney() >= Sword.PRICE) {
                   player.setMoney(player.getMoney() - Sword.PRICE);
                   player.weapon = new Sword();
               } else {
                   System.out.println("you don't have enough money to buy a Sword");
               }
           }
           case 3 -> {
               if (player.getMoney() >= Gun.PRICE) {
                   player.setMoney(player.getMoney() - Gun.PRICE);
                   player.weapon = new Gun();
               } else {
                   System.out.println("you don't have enough money to buy a Gun");
               }
           }
           default -> System.out.println("you didn't buy a weapon !");
       }
   }

    static private void buyArmor(Fighter player){
        Scanner sc = new Scanner(System.in);
        System.out.println("available armors :\n");
        for (Armor a : subClassesOfArmor) {
            System.out.println(a.getId()+". "
                    + a.getClass().getSimpleName()+String.format("%" + ((Biggest_ACNL+1)-a.getClass().getSimpleName().length() )+ "s","")
                    + "=> "
                    + String.format("%" + 15 + "s", " OBSTRUCTION : " + a.getObstruction() )
                    + String.format("%" + 15 + "s", "PRICE : " + a.getPrice() ));
        }
        System.out.println("\npress different key to quit");
        String answer = sc.nextLine();
        switch (Integer.parseInt(answer)) {
            case 1 -> {
                if (player.getMoney() >= Light.PRICE) {
                    player.setMoney(player.getMoney() - Light.PRICE);
                    player.armor = new Light();
                    System.out.println("now you have a Light Armor");
                } else {
                    System.out.println("you don't have enough money to buy a Light Armor");
                }
            }
            case 2 -> {
                if (player.getMoney() >= Average.PRICE) {
                    player.setMoney(player.getMoney() - Average.PRICE);
                    player.armor = new Average();
                } else {
                    System.out.println("you don't have enough money to buy an Average Armor");
                }
            }
            case 3 -> {
                if (player.getMoney() >= Heavy.PRICE) {
                    player.setMoney(player.getMoney() - Heavy.PRICE);
                    player.armor = new Heavy();
                } else {
                    System.out.println("you don't have enough money to buy a Heavy Armor");
                }
            }
            default -> System.out.println("you didn't buy an armor !");
        }
    }
}
