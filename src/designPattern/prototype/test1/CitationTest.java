package designPattern.prototype.test1;

import java.io.*;

public class CitationTest {
    public static void main(String[] args) throws Exception {
        // 1.创建原型对象
        Citation citation1 = new Citation();
        // 2.克隆奖状对象
        Student stu = new Student();
        stu.setName("张三");
        citation1.setStu(stu);

        // 创建对象输出流对象
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:/a.txt"));

        // 写对象
        oos.writeObject(citation1);

        oos.close();

        // 创建对象
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:/a.txt"));
        // 读取对象
        Citation citation2 = (Citation) ois.readObject();

        ois.close();

        Student stu2 = citation2.getStu();
        stu2.setName("李四");

        citation1.show();
        citation2.show();
    }
}
