package designPattern.singleton.demo3;

/**
 * 懒汉式：synchronized实现
 * 该方式也实现了懒加载效果，同时又解决了线程安全问题。但是在getInstance()方法上添加了synchronized关键字，导致该方法的执行效果特别低。从上面代码我们可以看出，其实就是在初始化instance的时候才会出现线程安全问题，一旦初始化完成就不存在了。
 */
public class Singleton {
    // 1.私有构造方法
    private Singleton(){}

    // 2.声明Singleton类型的变量instance
    private static Singleton instance;

    // 3.对外提供访问方式
    public static synchronized Singleton getInstance(){
        // 如果没有，创建一个并返回，如果有，直接返回
        if(instance == null){
            instance = new Singleton();
        }
        return instance;
    }
}
