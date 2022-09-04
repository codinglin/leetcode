package designPattern.facade;

public class Client {
    public static void main(String[] args) {
        // 创建智能音箱对象
        SmartAppliancesFacade facade = new SmartAppliancesFacade();
        facade.say("打开家电");

        facade.say("关闭家电");
    }
}
