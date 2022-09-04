package designPattern.decorator;

/**
 * 装饰者类 (抽象装饰者角色)
 */
public abstract class Garnish extends FastFood{

    // 声明快餐类的变量
    private FastFood fastFood;

    public Garnish(FastFood fastFood, float price, String desc) {
        super(price, desc);
        this.fastFood = fastFood;
    }

    public FastFood getFastFood() {
        return fastFood;
    }

    public void setFastFood(FastFood fastFood) {
        this.fastFood = fastFood;
    }
}
