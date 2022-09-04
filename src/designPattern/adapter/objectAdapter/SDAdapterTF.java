package designPattern.adapter.objectAdapter;

/**
 * 适配器类
 */
public class SDAdapterTF implements SDCard {
    // 声明适配者类
    private TFCard tfCard;

    public SDAdapterTF(TFCard tfCard){
        this.tfCard = tfCard;
    }

    @Override
    public String readSD() {
        System.out.println("Adapter read TFCard");
        return tfCard.readTF();
    }

    @Override
    public void writeSD(String msg) {
        System.out.println("Adapter write TFCard");
        tfCard.writeTF(msg);
    }
}
