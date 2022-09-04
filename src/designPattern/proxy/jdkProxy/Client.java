package designPattern.proxy.jdkProxy;

public class Client {
    public static void main(String[] args) {
        // 获取代理对象
        // 1.创建代理工厂对象
        ProxyFactory factory = new ProxyFactory();
        // 2.使用factory对象的方法获取代理对象
        SellTickets proxyObject = factory.getProxyObject();
        // 3.调用卖票的方法
        proxyObject.sell();
    }
}
