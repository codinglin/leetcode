package designPattern.proxy.staticProxy;

public class Client {
    public static void main(String[] args) {
        // 创建代售点类对象
        ProxyPoint proxyPoint = new ProxyPoint();

        // 调用方法进行买票
        proxyPoint.sell();
    }
}
