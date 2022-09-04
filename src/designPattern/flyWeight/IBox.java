package designPattern.flyWeight;

/**
 * I图形类 (具体享元角色)
 */
public class IBox extends AbstractBox {

    @Override
    public String getShape() {
        return "I";
    }
}
