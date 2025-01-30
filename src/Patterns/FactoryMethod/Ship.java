package Patterns.FactoryMethod;

public class Ship implements Transport{
    @Override
    public void deliver() {
        System.out.println("Доставка кораблем");
    }
}
