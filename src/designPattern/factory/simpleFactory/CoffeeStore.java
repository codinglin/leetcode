package designPattern.factory.simpleFactory;

/**
 * 咖啡店
 */
public class CoffeeStore {
    public Coffee orderCoffee(String type){
        SimpleCoffeeFactory factory = new SimpleCoffeeFactory();

        Coffee coffee = factory.createCoffee(type);

        coffee.addMike();
        coffee.addSugar();

        return coffee;
    }
}
