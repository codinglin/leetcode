package designPattern.prototype.test;

public class Student {
    // 学生的姓名
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }

    public void show(){
        System.out.println(name + "同学被评为三好学生！");
    }
}
