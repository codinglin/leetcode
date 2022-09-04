package designPattern.adapter.classAdapter;

/**
 * 适配器类
 */
public class SDAdapterTF extends TFCardImpl implements SDCard{
    @Override
    public String readSD() {
        System.out.println("Adapter read TFCard");
        return readTF();
    }

    @Override
    public void writeSD(String msg) {
        System.out.println("Adapter write TFCard");
        writeTF(msg);
    }
}
