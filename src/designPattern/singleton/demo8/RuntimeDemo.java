package designPattern.singleton.demo8;

import java.io.IOException;
import java.io.InputStream;

public class RuntimeDemo {
    public static void main(String[] args) throws IOException {
        // 获取Runtime类的对象
        Runtime runtime = Runtime.getRuntime();

        // 调用runtime的方法
        Process process = runtime.exec("ipconfig");

        // 调用process对象的获取输入流的方法
        InputStream is = process.getInputStream();
        byte[] arr = new byte[1024 * 1024 * 100];

        // 读取数据
        int len = is.read(arr);

        // 将字节数组转换为字符串输出到控制台
        System.out.println(new String(arr, 0, len, "GBK"));
    }

}
