package location.dangerous;

import character.BadCharacter;
import character.GoodCharacter;
import character.badCharacters.Zombie;
import prize.Prize;

import java.util.Scanner;

public abstract class DangerousLocation <b extends BadCharacter,p extends Prize> {
    public boolean isFoodTaken= false;
    static int num ;
    {
        num = (int) (Math.random() * 3+1);
    }
    public b[] badCharacters ;
    p prize ;

    public void battle(GoodCharacter player) {
        Scanner sc = new Scanner(System.in);
        System.out.println(player);
        if(num ==1)
            System.out.println("Here is "+num +" "+ Zombie.class.getSimpleName());
        else{System.out.println("Here are "+num +" "+Zombie.class.getSimpleName()+"s");}

        System.out.println("do you want to fight ? n/y");
        String answer = sc.next();
        if(answer.equalsIgnoreCase("y")){
            outer:
            for (BadCharacter badCharacter : badCharacters) {
                while (player.getHealth() > 0) {
                    badCharacter.setHealth(badCharacter.getHealth() - player.getDamage());
                    player.setHealth(player.getHealth() - badCharacter.getDamage());
                    System.out.println(
                            "player health : " + player.getHealth() + "\n" +
                                    Zombie.class.getSimpleName()+" health : " + badCharacter.getHealth() + "\n"
                    );
                    if (player.getHealth() <= 0)
                        break outer;
                    if (badCharacter.getHealth() <= 0)
                        break;
                }
                player.setMoney(player.getMoney()+badCharacter.getMoney());
            }
            if(!isFoodTaken){
                isFoodTaken=true;
                player.prizes.add(this.prize);
            }
        }
        if (player.getHealth()>0)
            System.out.println("you beat the "+Zombie.class.getSimpleName()+"s successfully");
    }
}
