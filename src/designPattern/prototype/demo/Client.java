package designPattern.prototype.demo;

/**
 * 原型模式的克隆分为浅克隆和深克隆。
 *
 * > 浅克隆：创建一个新对象，新对象的属性和原来对象完全相同，对于非基本类型属性，仍指向原有属性所指向的对象的内存地址。
 * >
 * > 深克隆：创建一个新对象，属性中引用的其他对象也会被克隆，不再指向原有对象地址。
 */
public class Client {
    public static void main(String[] args) throws CloneNotSupportedException {
        // 创建一个原型类对象
        RealizeType realizeType = new RealizeType();

        // 调用RealizeType类中的clone方法进行对象的克隆
        RealizeType clone = realizeType.clone();

        System.out.println(realizeType == clone);
    }
}
