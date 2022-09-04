package problems;

public class LeetCode50 {
    // 快速幂+递归
    double myPowHelper(double x,int n){
        if(n==1){
            return x;
        }
        if(n%2==0){
            double half = myPowHelper(x,n/2);
            return half*half;
        }else{
            double half = myPowHelper(x,n/2);
            return half*half*x;
        }
    }

    public double myPow(double x, int n) {
        if(n==0||x==1){
            return 1;
        }
        if(n<0){
            return 1.0/myPowHelper(x,n);
        }else {
            return myPowHelper(x,n);
        }
    }

    // 转递归为迭代
    public double myPowFor(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }

    public double quickMul(double x, long N) {
        double ans = 1.0;
        // 贡献的初始值为 x
        double x_contribute = x;
        // 在对 N 进行二进制拆分的同时计算答案
        while (N > 0) {
            if (N % 2 == 1) {
                // 如果 N 二进制表示的最低位为 1，那么需要计入贡献
                ans *= x_contribute;
            }
            // 将贡献不断地平方
            x_contribute *= x_contribute;
            // 舍弃 N 二进制表示的最低位，这样我们每次只要判断最低位即可
            N /= 2;
        }
        return ans;
    }
}
