package designPattern.singleton.demo2;

/**
 * 饿汉式：静态代码块
 * 该方式在成员位置声明Singleton类型的静态变量，而对象的创建是在静态代码块中，也是对着类的加载而创建。所以和饿汉式的方式1基本上一样，当然该方式也存在内存浪费问题。
 */
public class Singleton {
    // 1.私有构造方法
    private Singleton(){}

    // 2.声明Singleton类型的变量
    private static Singleton instance;

    // 3.在静态代码块中进行赋值
    static {
        instance = new Singleton();
    }

    // 4.对外提供获取该类对象的方法
    public static Singleton getInstance(){
        return instance;
    }
}

class Client{
    public static void main(String[] args) {
        // 创建Singleton类的对象
        Singleton instance1 = Singleton.getInstance();

        Singleton instance2 = Singleton.getInstance();

        // 判断获取到的两个是否是同一个对象
        System.out.println(instance1 == instance2);
    }
}
