package designPattern.decorator;

/**
 * 炒面 (具体构件角色)
 */
public class FriedNoddles extends FastFood{

    public FriedNoddles(){
        super(12, "炒面");
    }

    @Override
    public float cost() {
        return getPrice();
    }
}
