package location.dangerous;

import character.GoodCharacter;
import character.badCharacters.Zombie;
import prize.Food;
public class Cave extends DangerousLocation<Zombie, Food>{

    {
        this.badCharacters = new Zombie[num];
        for(int i=0;i<num;i++){
            this.badCharacters[i]=new Zombie();
        }
        this.prize = new Food();
    }

    @Override
    public void battle(GoodCharacter player) {
    super.battle(player);
    }
}