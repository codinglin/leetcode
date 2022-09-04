package designPattern.builder.demo1;

/**
 * 建造者模式可以将部件和其组装过程分开，一步一步创建一个复杂的对象。用户只需要指定复杂对象的类型就可以得到该对象，而无须知道其内部的具体构造细节。
 *
 * 建造者（Builder）模式包含如下角色：
 *
 * * 抽象建造者类（Builder）：这个接口规定要实现复杂对象的那些部分的创建，并不涉及具体的部件对象的创建。
 *
 * * 具体建造者类（ConcreteBuilder）：实现 Builder 接口，完成复杂产品的各个部件的具体创建方法。在构造过程完成后，提供产品的实例。
 *
 * * 产品类（Product）：要创建的复杂对象。
 *
 * * 指挥者类（Director）：调用具体建造者来创建复杂对象的各个部分，在指导者中不涉及具体产品的信息，只负责保证对象各部分完整创建或按某种顺序创建。
 *
 * 注意:
 *
 * 上面示例是 Builder模式的常规用法，指挥者类 Director 在建造者模式中具有很重要的作用，它用于指导具体构建者如何构建产品，控制调用先后次序，并向调用者返回完整的产品类，但是有些情况下需要简化系统结构，可以把指挥者类和抽象建造者进行结合
 */
public class Client {
    public static void main(String[] args) {
        // 创建指挥者对象
        Director director = new Director(new MobileBuilder());

        // 让指挥者组装自行车
        Bike bike = director.construct();

        System.out.println(bike.getFrame());
        System.out.println(bike.getSeat());
    }
}
