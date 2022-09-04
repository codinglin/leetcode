package designPattern.factory.factoryMethod;

/**
 * 咖啡店
 */
public class CoffeeStore {
    private CoffeeFactory factory;

    public void setFactory(CoffeeFactory factory) {
        this.factory = factory;
    }

    // 点咖啡功能
    public Coffee orderCoffee(){
        Coffee coffee = factory.createCoffee();
        coffee.addMike();
        coffee.addSugar();
        return coffee;
    }
}
