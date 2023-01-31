package location.dangerous;

import character.GoodCharacter;
import character.badCharacters.Vampire;
import prize.Wood;
public class Forest extends DangerousLocation<Vampire, Wood>{
   {
      this.badCharacters = new Vampire[num];
      for(int i=0;i<num;i++){
         this.badCharacters[i]=new Vampire();
      }
      this.prize = new Wood();
   }

   @Override
   public void battle(GoodCharacter player) {
      super.battle(player);
   }
}
