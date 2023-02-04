package character;

import items.armors.Armor;
import items.weapons.Weapon;
import prize.Prize;
import java.util.ArrayList;
import java.util.List;

public class Fighter extends Character{
    public int Max_Health ;
    public Armor armor;
    public Weapon weapon;
    public List<Prize> prizes = new ArrayList<>();
    protected Fighter(int id, int damage, int health, int money) {
        super(id, damage, health, money);
        Max_Health = health;
    }

    public int getMax_Health() {
        return this.Max_Health;
    }

    @Override
    public String toString() {
        String armorStr = "NOT FOUND",weaponStr = "NOT FOUND";
        if(armor !=null)
            armorStr = armor.toString();
        if(weapon != null)
            weaponStr = weapon.toString();
        return
                "************************************************************\n"+
                "Name : "+this.getClass().getSimpleName()+" || Damage : "+this.getDamage()+" || " +
                "Health : "+this.getHealth()+" || Money : "+this.getMoney()+"\n" +
                "Armor : "+armorStr+" || Weapon : "+ weaponStr +"\n"+
                "Prizes : "+this.prizes+
                "\n************************************************************";
    }
}
