package character.monsters;

import character.Monster;

public class Snake extends Monster {
    public static int DAMAGE;
    static {
        DAMAGE = (int) (Math.random()*4+3);
    }
    public Snake() {
        super(4, DAMAGE, 12, 0);
    }
}
