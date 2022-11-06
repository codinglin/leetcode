package problems;

import java.util.ArrayList;
import java.util.List;

/**
 * 设n阶格雷码集合为G(n)，则G(n+1)阶格雷码为：
 *      给G(n)阶格雷码每个元素二进制形式前面添加0，得到G'(n);
 *      设G(n)集合倒序（镜像）为R(n),给R(n)每个元素二进制形式前面添加1，得到R'(n);
 *      G(n+1) = G'(n) U R'(n)拼接两个集合即可得到下一阶格雷码
 * 根据以上规律，可从0阶格雷码推导到任何阶格雷码。
 */
public class LeetCode89 {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<Integer>() {{ add(0); }};
        int head = 1;
        for (int i = 0; i < n; i++) {
            for (int j = res.size() - 1; j >= 0; j--)
                res.add(head + res.get(j));
            head <<= 1;
        }
        return res;
    }
}
