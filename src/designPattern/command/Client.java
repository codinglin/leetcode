package designPattern.command;

import com.sun.org.apache.xpath.internal.operations.Or;

public class Client {
    public static void main(String[] args) {
        // 创建第一个订单对象
        Order order1 = new Order();
        order1.setOrderingTable(1);
        order1.setFood("西红柿鸡蛋面", 1);
        order1.setFood("可乐", 2);

        // 创建第二个订单对象
        Order order2 = new Order();
        order2.setOrderingTable(2);
        order2.setFood("鱼香肉丝盖饭", 1);
        order2.setFood("雪碧", 1);

        // 创建厨师对象
        SeniorChef receiver = new SeniorChef();
        // 创建命令对象
        OrderCommand cmd1 = new OrderCommand(receiver, order1);
        OrderCommand cmd2 = new OrderCommand(receiver, order2);

        // 创建调用者 (服务员对象)
        Waiter invoke = new Waiter();
        invoke.setCommand(cmd1);
        invoke.setCommand(cmd2);

        // 让服务员发起命令
        invoke.OrderUp();
    }
}
