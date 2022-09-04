package designPattern.facade;

/**
 * 外观类 (用户主要和该类对象进行交互)
 */
public class SmartAppliancesFacade {
    // 聚合点灯对象，电视机对象，空调对象
    private Light light;
    private TV tv;
    private AirCondition airCondition;

    public SmartAppliancesFacade(){
        light = new Light();
        tv = new TV();
        airCondition = new AirCondition();
    }

    // 通过语音控制
    public void say(String message){
        if(message.contains("打开")){
            on();
        }else if(message.contains("关闭")){
            off();
        }else {
            System.out.println("我还听不懂你说的话");
        }
    }

    // 一键打开功能
    private void on(){
        light.on();
        tv.on();
        airCondition.on();
    }

    private void off(){
        light.off();
        tv.off();
        airCondition.off();
    }
}
