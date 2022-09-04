package designPattern.factory.simpleFactory;

/**
 * 简单咖啡工厂类：生产咖啡
 */
public class SimpleCoffeeFactory {
    public Coffee createCoffee(String type){
        // 声明Coffee类型的变量，根据不同类型创建不同的coffee子类对象
        Coffee coffee = null;
        if("american".equals(type)){
            coffee = new AmericanCoffee();
        }else if("latte".equals(type)){
            coffee = new LatteCoffee();
        } else{
            throw new RuntimeException("对不起，您所点的咖啡没有");
        }
        return coffee;
    }
}
