package items.armors;

public class Armor {
    protected int id;
    protected int obstruction;
    protected int price;
    Armor(int id,int obstruction,int price){
        this.id = id;
        this.obstruction = obstruction;
        this.price = price;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() +" obstruction : "+getObstruction();
    }
    public int getId() {return this.id;}
    public int getObstruction() {return this.obstruction;}
    public int getPrice(){return this.price;}
}
