package character;

public abstract class Monster extends Character{

    protected Monster(int id, int damage, int health, int money) {
        super(id, damage, health, money);
    }

    @Override
    public String toString() {
        return "Damage : "+this.getDamage() +" || Health : "+this.getHealth()+" || Money : "+this.getMoney();
    }
}
