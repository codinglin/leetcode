package designPattern.decorator;

public class Client {
    public static void main(String[] args) {
        // 点一份炒饭
        FastFood food = new FriedRice();

        System.out.println(food.getDesc() + "->" + food.cost());

        // 在上面的炒饭中加一个鸡蛋
        food = new Egg(food);
        System.out.println(food.getDesc() + "->" + food.cost());
    }
}
