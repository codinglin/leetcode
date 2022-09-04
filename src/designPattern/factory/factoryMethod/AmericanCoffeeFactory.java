package designPattern.factory.factoryMethod;

/**
 * 美式咖啡工厂对象，专门用来生产美式咖啡
 */
public class AmericanCoffeeFactory implements CoffeeFactory {
    @Override
    public Coffee createCoffee() {
        return new AmericanCoffee();
    }
}
