package designPattern.template;

public class Client {
    public static void main(String[] args) {
        // 炒包菜, 创建对象
        ConcreteClassCabbage cabbage = new ConcreteClassCabbage();
        cabbage.cookProcess();
    }
}
