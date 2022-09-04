package designPattern.singleton.demo1;

/**
 * 饿汉式：静态成员变量
 * 该方式在成员位置声明Singleton类型的静态变量，并创建Singleton类的对象instance。instance对象是随着类的加载而创建的。如果该对象足够大的话，而一直没有使用就会造成内存的浪费。
 */
public class Singleton {
    // 1.私有构造方法
    private Singleton(){}

    // 2.在分类中创建本类对象
    private static Singleton instance = new Singleton();

    // 3.提供一个公共的访问方式，让外界获取该对象
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
