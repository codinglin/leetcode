package designPattern.visitor;

public class Client {
    public static void main(String[] args) {
        // 创建Home对象
        Home home = new Home();

        home.add(new Dog());
        home.add(new Cat());

        // 创建主人对象
        Owner owner = new Owner();

        // 让主人喂食所有的宠物
        home.action(owner);
    }
}
