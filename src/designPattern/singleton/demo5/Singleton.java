package designPattern.singleton.demo5;

/**
 * 饿汉式：静态内部类方式
 * 静态内部类单例模式是一种优秀的单例模式，是开源项目中比较常用的一种单例模式。在没有加任何锁的情况下，保证了多线程下的安全，并且没有任何性能影响和空间的浪费。
 */
public class Singleton {
    // 1.私有构造方法
    private Singleton(){}

    // 2.定义一个静态内部类
    private static class SingletonHolder{
        // 在内部类中声明并初始化外部类的对象
        private static final Singleton INSTANCE = new Singleton();
    }

    // 3.提供公共的访问方式
    public static Singleton getInstance(){
        return SingletonHolder.INSTANCE;
    }

}
