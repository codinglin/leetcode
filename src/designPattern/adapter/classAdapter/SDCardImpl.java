package designPattern.adapter.classAdapter;

public class SDCardImpl implements SDCard{
    @Override
    public String readSD() {
        String msg = "SDCard read message: hello world SDCard";
        return msg;
    }

    @Override
    public void writeSD(String msg) {
        System.out.println("SDCard write msg: " + msg);
    }
}
