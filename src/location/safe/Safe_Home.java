package location.safe;

import character.GoodCharacter;

public class Safe_Home {
    public static void Receive(GoodCharacter player) throws NoSuchFieldException, IllegalAccessException {
        player.setHealth((int) player.getClass().getField("Max_Health").get(player));
    }
}
