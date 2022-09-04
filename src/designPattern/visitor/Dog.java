package designPattern.visitor;

/**
 * 具体元素角色类
 */
public class Dog implements Animal {
    @Override
    public void accept(Person person) {
        person.feed(this);
        System.out.println("好好吃, 汪!");
    }
}
