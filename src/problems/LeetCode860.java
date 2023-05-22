package problems;

public class LeetCode860 {
    // 维护两个变量 five 和 ten 表示当前手中拥有 5 美元 和 10 美元钞票的张数
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int bill : bills) {
            if(bill == 5) {
                five++;
            } else if (bill == 10) {
                if(five == 0){
                    return false;
                }
                five --;
                ten ++;
            } else {
                if(five > 0 && ten > 0){
                    five --;
                    ten --;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
