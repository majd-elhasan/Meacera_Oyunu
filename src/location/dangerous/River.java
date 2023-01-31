package location.dangerous;

import character.GoodCharacter;
import character.badCharacters.Bear;
import prize.Water;
public class River extends DangerousLocation<Bear, Water>{
    {
        this.badCharacters = new Bear[num];
        for(int i=0;i<num;i++){
            this.badCharacters[i]=new Bear();
        }
        this.prize = new Water();
    }

    @Override
    public void battle(GoodCharacter player) {
        super.battle(player);
    }
}
