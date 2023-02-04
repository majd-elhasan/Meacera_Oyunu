package location.dangerous;

import character.Fighter;
import character.monsters.Vampire;
import prize.Wood;

public class Forest extends DangerousLocation<Vampire, Wood>{
   public static boolean IS_WOOD_TAKEN = false;

   @Override
   public boolean battle(Fighter player,int MaxNumberOfMonsters) {
      int numberOfMonsters =  (int) (Math.random() * MaxNumberOfMonsters+1);
      this.monsters = new Vampire[numberOfMonsters];
      for(int i=0;i<numberOfMonsters;i++){
         this.monsters[i] = new Vampire();
      }
      this.prize = new Wood();
      if (!IS_WOOD_TAKEN) IS_WOOD_TAKEN = super.battle(player,numberOfMonsters);
      return IS_WOOD_TAKEN;
   }
}
