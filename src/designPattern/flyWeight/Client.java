package designPattern.flyWeight;

public class Client {
    public static void main(String[] args) {
        // 获取I图形对象
        AbstractBox box1 = BoxFactory.getInstance().getShape("I");
        box1.display("灰色");
    }
}
