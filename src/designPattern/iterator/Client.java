package designPattern.iterator;

public class Client {
    public static void main(String[] args) {
        StudentAggregateImpl aggregate = new StudentAggregateImpl();

        aggregate.addStudent(new Student("张三", "001"));
        aggregate.addStudent(new Student("李四", "002"));
        aggregate.addStudent(new Student("王五", "003"));

        // 获取迭代器对象
        StudentIterator iterator = aggregate.getStudentIterator();
        while (iterator.hasNext()){
            Student student = iterator.next();
            System.out.println(student.toString());
        }
    }
}
