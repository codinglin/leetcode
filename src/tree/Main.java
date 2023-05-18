package tree;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean legal = true;
        boolean finish = false;
        int win1 = 0;
        int win2 = 0;
        List<String> list = new ArrayList<String>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.isEmpty()) {
                break;
            }
            list.add(line);
        }
        String[] points = list.toArray(new String[0]);
        if (points.length < 4 || points.length > 7) {
            legal = false;
        } else {
            for (int i = 0; i < points.length; i++) {
                if (points[i].length() != 5) {
                    legal = false;
                    break;
                } else if (points[i].charAt(2) != ':') {
                    legal = false;
                    break;
                } else {
                    if(finish == true){
                        legal = false;
                    }
                    else{
                        if (points[i].charAt(0) < '0' || points[i].charAt(0) > '9' || points[i].charAt(1) < '0'
                                || points[i].charAt(1) > '9' || points[i].charAt(3) < '0' || points[i].charAt(3) > '9'
                                || points[i].charAt(4) < '0' || points[i].charAt(4) > '9') {
                            legal = false;
                        } else {
                            int point1 = Integer.parseInt(points[i].substring(0, 2));
                            int point2 = Integer.parseInt(points[i].substring(3, 5));
                            if ((point1 == 11 && point2 < 10) || (point1 > 11 && point1 - point2 == 2)) {
                                win1++;
                            } else if ((point2 == 11 && point1 < 10) || (point2 > 11 && point2 - point1 == 2)) {
                                win2++;
                            } else {
                                legal = false;
                                break;
                            }
                            if(win1 ==4 || win2 ==4)
                            {
                                finish = true;
                            }
                        }
                    }
                }
            }
        }
        if (!legal) {
            System.out.println("输入比分无效！");
        } else {
            if (win1 == 4 && win2 < 4) {
                System.out.println("甲选手获胜");
            } else if (win2 == 4 && win1 < 4) {
                System.out.println("乙选手获胜");
            } else {
                System.out.println("输入比分无效！");
            }
        }
    }
}