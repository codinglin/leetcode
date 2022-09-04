package designPattern.command;

import java.util.HashMap;
import java.util.Map;

/**
 * 订单类
 */
public class Order {
    // 餐桌号码
    private int OrderingTable;

    // 所下的餐品及份数
    private Map<String, Integer> foodDir = new HashMap<>();

    public int getOrderingTable() {
        return OrderingTable;
    }

    public void setOrderingTable(int orderingTable) {
        OrderingTable = orderingTable;
    }

    public Map<String, Integer> getFoodDir() {
        return foodDir;
    }

    public void setFood(String name, int num) {
        foodDir.put(name, num);
    }
}
