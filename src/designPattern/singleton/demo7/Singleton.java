package designPattern.singleton.demo7;

import java.lang.reflect.Constructor;

/**
 * 测试
 */
public class Singleton {

    //私有构造方法
    private Singleton() {
        // 反射破坏单例模式需要添加的代码
        if(instance != null){
            throw new RuntimeException();
        }
    }

    private static volatile Singleton instance;

    //对外提供静态方法获取该对象
    public static Singleton getInstance() {

        if(instance != null) {
            return instance;
        }

        synchronized (Singleton.class) {
            if(instance != null) {
                return instance;
            }
            instance = new Singleton();
            return instance;
        }
    }
}

class Client{
    public static void main(String[] args) throws Exception {
        // 1.获取Singleton的字节码对象
        Class singleton = Singleton.class;
        // 2.获取无参构造方法对象
        Constructor cons = singleton.getDeclaredConstructor();
        // 3.取消访问检查
        cons.setAccessible(true);
        // 4.创建Singleton对象
        Singleton s1 = (Singleton) cons.newInstance();
        Singleton s2 = (Singleton) cons.newInstance();
        System.out.println(s1 == s2);
    }
}
