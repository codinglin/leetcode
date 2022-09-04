package problems;

public class LeetCode69 {
    // 二分查找
    public int mySqrt(int x) {
        int l=0, r=x, ans=-1;
        while(l<=r){
            int mid = l + (r-1) /2;
            if((long) mid*mid <=x){
                ans = mid;
                l = mid+1;
            }else{
                r = mid-1;
            }
        }
        return ans;
    }

    /*
    * 牛顿迭代：一种可以快速求解函数零点的方法。
    * 用C表示待求出平方根的那个整数。显然，C的平方根就是函数
    *   y=f(x)=x^2-C 的零点。
    *
    * 算法：我们选择x0=C作为初始值。
    *   在每一步迭代中，我们通过当前的交点xi,找到函数图像上的点(xi,xi^2-C)
    *   作一条斜率为f'(xi)=2*xi的直线，直线的方程为：
    *
    * */
    // TODO
    public int mySqrt1(int x) {
        if (x == 0) {
            return 0;
        }

        double C = x, x0 = x;
        while (true) {
            double xi = 0.5 * (x0 + C / x0);
            if (Math.abs(x0 - xi) < 1e-7) {
                break;
            }
            x0 = xi;
        }
        return (int) x0;
    }
}
