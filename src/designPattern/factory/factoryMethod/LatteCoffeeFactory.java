package designPattern.factory.factoryMethod;

/**
 * 拿铁咖啡工厂类
 */
public class LatteCoffeeFactory implements CoffeeFactory {
    @Override
    public Coffee createCoffee() {
        return new LatteCoffee();
    }
}
