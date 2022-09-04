package designPrinciples.demo2.before;

public class RectangleDemo {
    public static void main(String[] args) {
        // 创建长方形对象
        Rectangle r = new Rectangle();
        r.setLength(20);
        r.setWidth(10);
        resize(r);
        printLengthAndWidth(r);
    }

    public static void resize(Rectangle rectangle){
        // 判断宽如果比长小，进行扩宽的操作
        while (rectangle.getWidth() <= rectangle.getLength()){
            rectangle.setWidth(rectangle.getWidth() + 1);
        }
    }

    public static void printLengthAndWidth(Rectangle rectangle){
        System.out.println(rectangle.getLength());
        System.out.println(rectangle.getWidth());
    }

}
