package location.dangerous;

import character.*;
import prize.Prize;
import java.util.Random;
import java.util.Scanner;

public abstract class DangerousLocation <m extends Monster,p extends Prize> {
    public boolean isPrizeTaken = false;
    public m[] monsters;
    p prize;

    public boolean battle(Fighter player,int numberOfMonsters) {
        String monsterName = monsters[0].getClass().getSimpleName();

        Scanner sc = new Scanner(System.in);
        System.out.println(player);
        if(numberOfMonsters ==1)
            System.out.print("Here is "+numberOfMonsters +" "+ monsterName);
        else{System.out.print("Here are "+numberOfMonsters +" "+monsterName+"s");}
        System.out.println("\t"+monsters[0]);
        System.out.println("do you want to fight ? n/y");
        String answer = sc.next();
        if(answer.equalsIgnoreCase("y")){
            int i = 0;
            outer:
            for (Monster monster : monsters) {
                boolean playerFirst = new Random().nextBoolean();
                i++;
                while (player.getHealth() > 0) {
                    if (playerFirst) playerHitting(player,monster);
                    else if(!monsterHitting(player,monster)) break outer;
                    System.out.println(
                            "player health : " + player.getHealth() + "\n" +
                            (i) +". "+monster.getClass().getSimpleName()+" health : " + monster.getHealth() + "\n"
                    );
                    if (player.getHealth() <= 0)
                        break outer;
                    if (monster.getHealth() <= 0)
                        break;
                }
                player.setMoney(player.getMoney()+ monster.getMoney());
            }

            if (player.getHealth()>0){
                if(!isPrizeTaken && this.prize!=null){
                    isPrizeTaken =true;
                    player.prizes.add(this.prize);
                }
                System.out.println("you beat the "+monsterName+"s successfully");
                return true;
            }
        }
    return false;
    }
    void playerHitting(Fighter f,Monster m){
        int weaponDamage = f.weapon!=null? f.weapon.getDamage():0;
        int armorObstruction = f.armor!=null? f.armor.getObstruction():0;
        System.out.println("you hit !");
        m.setHealth(m.getHealth() - f.getDamage() - weaponDamage);
        if (m.getHealth()>0){
            System.out.println("the "+ m.getClass().getSimpleName() +" hit !");
            f.setHealth(f.getHealth() + armorObstruction - m.getDamage());
        }
    }
    boolean monsterHitting(Fighter f,Monster m){
        int weaponDamage = f.weapon!=null? f.weapon.getDamage():0;
        int armorObstruction = f.armor!=null?f.armor.getObstruction():0;

        if (m.getHealth()>0){
            System.out.println("the "+ m.getClass().getSimpleName() +" hit !");
            f.setHealth(f.getHealth() + armorObstruction - m.getDamage());
            if (f.getHealth()<=0)
                return false;
        }
        System.out.println("you hit !");
        m.setHealth(m.getHealth() - f.getDamage() - weaponDamage);
    return true;
    }

}
