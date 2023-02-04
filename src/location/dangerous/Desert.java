package location.dangerous;

import character.Fighter;
import character.monsters.Snake;
import items.armors.*;
import items.weapons.*;
import prize.Prize;
import java.util.Scanner;

public class Desert extends DangerousLocation<Snake, Prize>{
    Scanner input = new Scanner(System.in);
    @Override
    public boolean battle(Fighter player,int MaxNumberOfMonsters) {
        int numberOfMonsters =  (int) (Math.random() * MaxNumberOfMonsters+1);
        this.monsters = new Snake[numberOfMonsters];
        for(int i=0;i<numberOfMonsters;i++){
            this.monsters[i] = new Snake();
        }
        this.prize = null;

        boolean isAlive = super.battle(player,numberOfMonsters);
        if(isAlive){
            int itemChance = (int) (Math.random()*100+1);
            switch ((itemChance <= 15) ? 1 :
                    (itemChance <= 30) ? 2 :
                    (itemChance <= 55) ? 3 : 4) {
                case 1 -> {
                    Weapon[] arr = {new Gun(),new Sword(),new Pistol()};
                    getChance(player,arr);
                }
                case 2 -> {
                    Armor[] arr = {new Heavy(),new Average(),new Light()};
                    getChance(player,arr);
                }
                case 3 -> {
                    Integer[] arr = {10,5,1}; // money
                    getChance(player,arr);
                }
                case 4 -> System.out.println("you won nothing !");
            }
        }
        return isAlive;
    }
    void getChance(Fighter player, Object[] threePrizes){
        int typeChance = (int) (Math.random()*10+1);
        int p = (typeChance<=2) ? 0: (typeChance<=5) ? 1:2;
        String itemType = threePrizes[p].getClass().getSuperclass().getSimpleName();
        String itemSpecificName = threePrizes[p].getClass().getSimpleName();

        if (threePrizes[p] instanceof Weapon) {
            System.out.println("you won a "+itemSpecificName +", Do you want to use it ? (y/n)");
            if(input.nextLine().equalsIgnoreCase("y"))
                player.weapon = (Weapon) threePrizes[p];
        }
        else if (threePrizes[p] instanceof Armor) {
            System.out.println("you won a " + itemSpecificName +" "+itemType+ ", Do you want to use it ? (y/n)");
            if (input.nextLine().equalsIgnoreCase("y"))
                player.armor = (Armor) threePrizes[p];
        }
        else if (threePrizes[p] instanceof Integer){
            System.out.println("you won "+threePrizes[p] + "unit money");
            player.setMoney(player.getMoney()+(Integer) threePrizes[p]);
        }
    }
}

