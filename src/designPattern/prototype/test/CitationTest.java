package designPattern.prototype.test;

public class CitationTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        // 1.创建原型对象
        Citation citation1 = new Citation();
        // 2.克隆奖状对象
        Student stu = new Student();
        stu.setName("张三");
        citation1.setStu(stu);

        // 2.克隆奖状对象
        Citation citation2 = citation1.clone();
        citation2.getStu().setName("李四");

//        citation1.setName("张三");
//
//        citation2.setName("李四");



        // 3.调用show方法展示
        citation1.show();
        citation2.show();
    }
}
