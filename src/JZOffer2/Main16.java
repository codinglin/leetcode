package JZOffer2;

/**
 * 递归写法
 */
public class Main16 {
    public double myPow(double x, int n) {
        return myPow(x, (long) n);
    }

    private double myPow(double x, long b) {
        if (b == 0)
            return 1.0;
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }
        if (b % 2 == 1) {
            return myPow(x, b - 1) * x;
        } else {
            double temp = myPow(x, b / 2);
            return temp * temp;
        }
    }
}

/**
 * 非递归快速幂
 */
class Main16_1 {
    public double myPow(double x, int n) {
        if(x == 0) {
            return 0;
        }
        long b = n;
        double res = 1.0;
        if(b < 0) {
            x = 1 / x;
            b = -b;
        }
        while (b > 0) {
            if((b & 1) == 1) {
                res *= x;
            }
            x *= x;
            b >>= 1;
        }
        return res;
    }
}
