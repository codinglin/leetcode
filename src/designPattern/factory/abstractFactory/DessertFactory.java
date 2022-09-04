package designPattern.factory.abstractFactory;

/**
 * 甜品工厂类
 */
public interface DessertFactory {
    // 生产咖啡的功能
    Coffee createCoffee();

    // 生产甜品的功能
    Dessert createDessert();
}
