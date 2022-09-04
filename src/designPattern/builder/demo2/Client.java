package designPattern.builder.demo2;

public class Client {
    public static void main(String[] args) {
        // 创建手机对象，通过构建者对象创建手机对象
        Phone phone = new Phone.Builder()
                .cpu("intel")
                .screen("三星屏幕")
                .memory("金士顿内存条")
                .mainBoard("华硕主板")
                .build();

        System.out.println(phone);
    }
}
