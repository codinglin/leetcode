package designPattern.adapter.classAdapter;

public class Client {
    public static void main(String[] args) {
        // 创建计算机对象
        Computer computer = new Computer();

        // 读取SD卡中的数据
        String msg = computer.readSD(new SDCardImpl());

        System.out.println(msg);

        // 使用该电脑读取TF卡中的数据
        // 定义适配器类
        String s = computer.readSD(new SDAdapterTF());
        System.out.println(s);
    }
}
