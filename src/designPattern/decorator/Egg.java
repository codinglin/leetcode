package designPattern.decorator;

/**
 * 鸡蛋类 (具体装饰者角色)
 */
public class Egg extends Garnish {

    public Egg(FastFood fastFood){
        super(fastFood, 1, "鸡蛋");
    }

    @Override
    public float cost() {
        // 计算价格
        return super.getPrice() + getFastFood().cost();
    }

    @Override
    public String getDesc() {
        return super.getDesc() + getFastFood().getDesc();
    }
}
