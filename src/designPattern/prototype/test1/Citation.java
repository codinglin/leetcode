package designPattern.prototype.test1;

import java.io.Serializable;

public class Citation implements Cloneable, Serializable {

    private Student stu;

    public Student getStu() {
        return stu;
    }

    public void setStu(Student stu) {
        this.stu = stu;
    }

    public void show(){
        System.out.println(stu.getName() + "同学被评为三好学生！");
    }

    @Override
    public Citation clone() throws CloneNotSupportedException {
        return (Citation) super.clone();
    }
}
