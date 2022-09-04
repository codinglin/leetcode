package designPrinciples.demo2.after;

public class RectangleDemo {
    public static void main(String[] args) {
        Rectangle r = new Rectangle();
        r.setLength(20);
        r.setWidth(10);
        resize(r);
        printLengthAndWidth(r);
    }

    public static void resize(Rectangle rectangle){
        while (rectangle.getWidth() <= rectangle.getLength()){
            rectangle.setWidth(rectangle.getWidth() + 1);
        }
    }

    private static void printLengthAndWidth(Quadrilateral quadrilateral){
        System.out.println(quadrilateral.getLength());
        System.out.println(quadrilateral.getWidth());
    }
}
