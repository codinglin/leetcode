package designPattern.proxy.staticProxy;

/**
 * 代售点类
 */
public class ProxyPoint implements SellTickets{
    // 声明火车站类对象
    private TrainStation trainStation = new TrainStation();

    @Override
    public void sell() {
        System.out.println("代理点收取一些服务费");
        trainStation.sell();
    }
}
