package designPattern.adapter.objectAdapter;

/**
 * 目标接口
 */
public interface SDCard {
    // 从SD卡中读取数据
    String readSD();

    // 往SD卡中写数据
    void writeSD(String msg);
}
