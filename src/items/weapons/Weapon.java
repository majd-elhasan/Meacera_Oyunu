package items.weapons;

public class Weapon {
    int id;
    int damage;
    int price;
    public Weapon(int id,int damage,int price){
        this.id = id;
        this.damage = damage;
        this.price = price;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName()+" damage : "+this.getDamage();
    }

    public int getDamage() {
        return this.damage;
    }

    public int getId() {return this.id;}
    public int getPrice() {return this.price;}
}
