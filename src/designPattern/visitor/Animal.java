package designPattern.visitor;

/**
 * 抽象元素角色类
 */
public interface Animal {
    // 接受访问者访问的功能
    void accept(Person person);
}
