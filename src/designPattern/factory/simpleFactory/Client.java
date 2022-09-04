package designPattern.factory.simpleFactory;

/**
 * 简单工厂包含如下角色：
 *
 * * 抽象产品 ：定义了产品的规范，描述了产品的主要特性和功能。
 * * 具体产品 ：实现或者继承抽象产品的子类
 * * 具体工厂 ：提供了创建产品的方法，调用者通过该方法来获取产品。
 */
public class Client {
    public static void main(String[] args) {
        CoffeeStore store = new CoffeeStore();
        Coffee coffee = store.orderCoffee("latte");
        System.out.println(coffee.getName());
    }
}
