package designPattern.strategy;

/**
 * 具体策略类，封装算法
 */
public class StrategyB implements Strategy{
    @Override
    public void show() {
        System.out.println("买200减50");
    }
}
