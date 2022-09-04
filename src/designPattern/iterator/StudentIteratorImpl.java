package designPattern.iterator;

import java.util.List;

/**
 * 具体迭代角色类对象
 */
public class StudentIteratorImpl implements StudentIterator{
    private List<Student> list;

    private int position = 0;

    public StudentIteratorImpl(List<Student> list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        return position < list.size();
    }

    @Override
    public Student next() {
        Student currentStudent = list.get(position++);
        return currentStudent;
    }
}
