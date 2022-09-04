package designPattern.observer;

public class Client {
    public static void main(String[] args) {
        // 创建公众号对象
        SubscriptionSubject subject = new SubscriptionSubject();

        // 订阅公众号
        subject.attach(new WeChatUser("小明"));
        subject.attach(new WeChatUser("小方"));

        // 公众号更新，发出消息给订阅者
        subject.notify("专栏更新啦!");
    }
}
