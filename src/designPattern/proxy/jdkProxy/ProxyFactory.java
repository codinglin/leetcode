package designPattern.proxy.jdkProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 获取代理对象的工厂类
 */
public class ProxyFactory {
    // 声明目标对象
    private TrainStation station = new TrainStation();

    public SellTickets getProxyObject(){
        // 返回代理对象即可
        /*
         * ClassLoader loader:类加载器，用于加载代理类（可以通过目标对象获取类加载器）
         * Class<?>[] interfaces:代理类实现的接口的字节码对象
         * invocationHandler h:代理对象的调用处理程序
         */
        SellTickets proxyObject = (SellTickets)Proxy.newProxyInstance(
                station.getClass().getClassLoader(),
                station.getClass().getInterfaces(),
                new InvocationHandler() {
                    /**
                     * @param proxy: 代理对象，和ProxyObject是同一个对象，在invoke方法中基本不用。
                     * @param method: 对接口中的方法进行封装的Method对象。
                     * @param args: 调用方法的实际参数
                     * @return: 方法的返回值
                     * @throws Throwable
                     */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("代售点收取一定的服务费用");
                        // 执行目标的方法
                        Object obj = method.invoke(station, args);
                        return obj;
                    }
                }
        );
        return proxyObject;
    }
}
