package location.safe;

import character.GoodCharacter;
import items.weapons.Gun;
import items.weapons.Pistol;
import items.weapons.Sword;
import java.util.Scanner;

public class Store {

    static int Biggest_Class_Name_Length =0;
    final static Class[] subClassesOfWeapon = {Pistol.class, Sword.class, Gun.class};
   public static void Receive(GoodCharacter player) throws NoSuchFieldException, IllegalAccessException {
       Scanner sc = new Scanner(System.in);
       for (int i=0;i<subClassesOfWeapon.length;i++){
           if (Biggest_Class_Name_Length < subClassesOfWeapon.getClass().getSimpleName().length()) {
               Biggest_Class_Name_Length = subClassesOfWeapon.getClass().getSimpleName().length();
           }
       }
        System.out.println("what do you want to buy ?");
        System.out.println("1. Weapon\n2. Armor\n");
        int answer =0;

       answer = Integer.parseInt(sc.nextLine());

        if(answer == 1){
             buyWeapon(player);
        } else if (answer ==2) {
            buyArmor();
        }else {
            System.out.println("you didn't buy anything !");
        }


    }
   static private void buyWeapon(GoodCharacter player) throws NoSuchFieldException, IllegalAccessException {
       Scanner sc = new Scanner(System.in);
       System.out.println("available weapons :\n");
       for (Class aClass : subClassesOfWeapon) {
           System.out.println(aClass.getSimpleName()+String.format("%" + ((Biggest_Class_Name_Length)-aClass.getSimpleName().length() )+ "s","")
                   + "=> " +String.format("%"+2+"s","ID : " + aClass.getField("ID").get(aClass) )
                   + String.format("%" + 15 + "s", " DAMAGE : " + aClass.getField("DAMAGE").get(aClass) )
                   + String.format("%" + 15 + "s", "PRICE : " + aClass.getField("PRICE").get(aClass) ) + "\n");
       }
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
       }
   }

    static private void buyArmor(){
    }
}
