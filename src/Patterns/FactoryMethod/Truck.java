package Patterns.FactoryMethod;

public class Truck implements Transport{
    @Override
    public void deliver() {
        System.out.println("Доставка фурой");
    }
}
