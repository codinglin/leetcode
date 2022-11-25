package NiukeTOP101;

public class BM63 {
    public int jumpFloor(int target) {
        int[] jump = new int[target + 1];
        if(target == 1){
            return 1;
        }
        if(target == 2){
            return 2;
        }
        jump[0] = 1;
        jump[1] = 1;
        for (int i = 2; i <= target; i++) {
            jump[i] = jump[i-1] + jump[i-2];
        }
        return jump[target];
    }
}


class BM63_1{
    public int jumpFloor(int target) {
        //这里第0项为1，第1项为1
        if(target <= 1)
            return 1;
        else
            //递归子问题相加
            return jumpFloor(target - 1) + jumpFloor(target - 2);
    }
}
