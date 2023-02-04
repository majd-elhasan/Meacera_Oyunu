package location.dangerous;

import character.Fighter;
import character.monsters.Bear;
import prize.Water;

public class River extends DangerousLocation<Bear, Water>{
    public static boolean IS_WATER_TAKEN = false;

    @Override
    public boolean battle(Fighter player,int MaxNumberOfMonsters) {
        int numberOfMonsters =  (int) (Math.random() * MaxNumberOfMonsters+1);
        this.monsters = new Bear[numberOfMonsters];
        for(int i=0;i<numberOfMonsters;i++){
            this.monsters[i] = new Bear();
        }
        this.prize = new Water();
        if (!IS_WATER_TAKEN) IS_WATER_TAKEN = super.battle(player,numberOfMonsters);
        return IS_WATER_TAKEN;
    }
}
