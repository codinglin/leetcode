package designPattern.adapter.objectAdapter;

/**
 * 适配者类
 */
public class TFCardImpl implements TFCard {
    @Override
    public String readTF() {
        String msg = "TFCard read message: hello world TFCard";
        return msg;
    }

    @Override
    public void writeTF(String msg) {
        System.out.println("TFCard write msg: " + msg);
    }
}
