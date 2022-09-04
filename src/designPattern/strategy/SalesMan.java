package designPattern.strategy;

/**
 * 促销员 (环境类)
 */
public class SalesMan {
    // 聚合策略类对象
    private Strategy strategy;

    public SalesMan(Strategy strategy){
        this.strategy = strategy;
    }

    // 由促销员展示促销活动给用户
    public void salesManShow(){
        strategy.show();
    }
}
