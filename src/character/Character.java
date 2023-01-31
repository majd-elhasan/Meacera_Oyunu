package character;

public class Character {
    private int id = 0;
    private int damage = 0;
    private int health = 0;
    private int money = 0;
    Character(int id,int damage,int health,int money){
        this.id = id;
        this.damage = damage;
        this.health = health;
        this.money = money;
    }
    public int getId() {
        return id;
    }

    public int getDamage() {
        return damage;
    }

    public int getHealth() {
        return health;
    }

    public int getMoney() {
        return money;
    }

    public void setHealth(int health) {
        if(health < 0)
            this.health = 0;
        else
            this.health = health;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
