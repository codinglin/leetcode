package designPattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 具体主题角色类
 */
public class SubscriptionSubject implements Subject {
    // 定义一个集合，用来存储多个观察者对象
    private List<Observer> weChatUserList = new ArrayList<>();

    @Override
    public void attach(Observer observer) {
        weChatUserList.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        weChatUserList.remove(observer);
    }

    @Override
    public void notify(String message) {
        for (Observer observer : weChatUserList) {
            // 调用观察者对象中的update方法
            observer.update(message);
        }
    }
}
