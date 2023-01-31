package items.weapons;

public class Weapon {
    int id =0;
    int damage=0;
    int price=0;
    public Weapon(int id,int damage,int price){
        this.id = id;
        this.damage = damage;
        this.price = price;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
