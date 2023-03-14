package JZOfferTuJi;

/*
* 二进制除法：
*   1.同为0,异为1.
*   2.被除数位数不够,商为0.
*           位数够,商为1.
* */
public class Main1 {
    /* 最初版本
    public int divide1(int a, int b){
//        int sign = 1;
//        if((a>0 && b<0) || (a<0 && b>0)){
//            sign = -1;
//        }
        // 32位最大值:2^31 - 1 = 2147483647
        // 32位最小值:-2^31 = -2147483648
        if(a == Integer.MIN_VALUE && b == -1)
            return Integer.MAX_VALUE;
        int sign = (a > 0) ^ (b > 0) ? -1 : 1;
        a = Math.abs(a);
        b = Math.abs(b);
        int res = 0;
        while (a >= b){
            a -= b;
            res ++;
        }
        return sign * res;
    }
    */

    /*
    public int divide2(int a, int b){
        // 32位最大值:2^31 - 1 = 2147483647
        // 32位最小值:-2^31 = -2147483648
        if(a == Integer.MIN_VALUE && b == -1)
            return Integer.MAX_VALUE;
        int sign = (a > 0) ^ (b > 0) ? -1 : 1;
        if (a > 0) a = -a;
        if (b > 0) b = -b;
        int res = 0;
        while (a <= b){
            a -= b;
            res ++;
        }
        return sign * res;
    }
    */


    // 优化：尝试每次减去除数的倍数
    // 时间复杂度:O(logn * logn), n是最大值2147483547 --> 10^10
    /*
    public int divide3(int a, int b){
        // 32位最大值:2^31 - 1 = 2147483647
        // 32位最小值:-2^31 = -2147483648
        if(a == Integer.MIN_VALUE && b == -1)
            return Integer.MAX_VALUE;
        int sign = (a > 0) ^ (b > 0) ? -1 : 1;
        if (a > 0) a = -a;
        if (b > 0) b = -b;
        int res = 0;
        while (a <= b){
            int value = b;
            int k = 1;
            // 0xc0000000是十进制-2^30的十六进制的表示
            // 判断value >= 0xc0000000的原因：保证value + value不会溢出
            // 可以这样判断的原因是:0xc0000000是最小值-2^31的一半,
            // 而a的值不可能比-2^31还要小，所以value不可能比0xc0000000小
            while (value >= 0xc0000000 && a <= value + value){
                value += value;
                k += k;
            }
            a -= value;
            res += k;
        }
        return sign * res;
    }
    */


    // 时间复杂度:O(1)
    // 位运算，每次从最大位数开始尝试，31位、30位...
    public int divide(int a, int b){
        // 32位最大值:2^31 - 1 = 2147483647
        // 32位最小值:-2^31 = -2147483648
        if(a == Integer.MIN_VALUE && b == -1)
            return Integer.MAX_VALUE;
        int sign = (a > 0) ^ (b > 0) ? -1 : 1;
        a = Math.abs(a);
        b = Math.abs(b);
        int res = 0;
        for(int i=31; i>=0; i--){
            /*
                首先，右移不会产生越界
                其次，无符号右移的目的是：将-2147483648 看成 2147483648
                注意：这里不能是(a >>> i) >= b而应该是(a >>> i) - b >=0
                为了避免b = -2147483648, (a >>> i) >= b永远为true,但是(a >>> i) - b >=0 为false.
            */
            if((a >>> i) - b >= 0){
                a -= (b << i);
                if(res > Integer.MAX_VALUE - (1 << i)){
                    return Integer.MIN_VALUE;
                }
                res += (1 << i);
            }
        }
        return sign == 1 ? res : -res;
    }
}
