package designPattern.singleton.demo6;

/**
 * 单例设计模式分类两种：
 * 	饿汉式：类加载就会导致该单实例对象被创建。
 * 	懒汉式：类加载不会导致该单实例对象被创建，而是首次使用该对象时才会创建。
 */

/**
 * 恶汉式：枚举实现方式
 * 枚举类实现单例模式是极力推荐的单例实现模式，因为枚举类型是线程安全的，并且只会装载一次，设计者充分的利用了枚举的这个特性来实现单例模式，枚举的写法非常简单，而且枚举类型是所用单例实现中唯一一种不会被破坏的单例实现模式。
 */
public enum Singleton {
    INSTANCE;
}

class Client{
    public static void main(String[] args) {
        Singleton instance1 = Singleton.INSTANCE;
        Singleton instance2 = Singleton.INSTANCE;
        System.out.println(instance1 == instance2);
    }
}
