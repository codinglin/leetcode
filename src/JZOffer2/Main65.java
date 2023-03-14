package JZOffer2;

/**
 * 无进位和n 与 进位c 的计算公式如下：
 *      n=a⊕b       非进位和：异或运算
 *      c=a&b<<1    进位：与运算 + 左移一位
 *      （和 s ）=（非进位和 n ）+（进位 c ）。即可将 s = a + b 转化为：
 *      s=a+b => s=n+c
 *      循环求 n 和 c ，直至进位 c = 0 ；此时 s = n ，返回 n 即可。
 */
public class Main65 {
    public int add(int a, int b) {
        while(b != 0) { // 当进位为 0 时跳出
            int c = (a & b) << 1;  // c = 进位
            a ^= b; // a = 非进位和
            b = c; // b = 进位
        }
        return a;
    }
}
