package designPattern.adapter.objectAdapter;

/**
 * 适配者类接口
 */
public interface TFCard {
    // 从TF卡中读取数据
    String readTF();

    // 往TF卡中写数据
    void writeTF(String msg);
}
