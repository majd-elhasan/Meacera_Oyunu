package location.dangerous;

import character.Fighter;
import character.monsters.Zombie;
import prize.Food;
public class Cave extends DangerousLocation<Zombie, Food>{
    public static boolean IS_FOOD_TAKEN = false;
    @Override
    public boolean battle(Fighter player,int MaxNumberOfMonsters) {
        int numberOfMonsters =  (int) (Math.random() * MaxNumberOfMonsters+1);
        this.monsters = new Zombie[numberOfMonsters];
        for(int i=0;i<numberOfMonsters;i++){
            this.monsters[i] = new Zombie();
        }
        this.prize = new Food();
        if (!IS_FOOD_TAKEN) IS_FOOD_TAKEN =  super.battle(player,numberOfMonsters);
        return IS_FOOD_TAKEN;
    }
}