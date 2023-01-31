package character;

import items.armors.Armor;
import items.weapons.Weapon;
import prize.Prize;

import java.util.ArrayList;
import java.util.List;

public class GoodCharacter extends Character{
    protected Armor armor;
    public Weapon weapon;
    public List<Prize> prizes = new ArrayList<>();
    protected GoodCharacter(int id, int damage, int health, int money) {
        super(id, damage, health, money);
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
                "Armor : "+armorStr+" || Weapon : "+ weaponStr +
                "\n************************************************************"
                ;


    }
}
