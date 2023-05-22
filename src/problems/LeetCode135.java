package problems;

/**
 * 拆分为两个规则，分别处理。
 *      左规则：当 ratings[i-1] < ratings[i] 时，i 号学生的糖果数量将比 i-1 号孩子的糖果数量多。
 *      右规则：当 ratings[i] > ratings[i+1] 时，i 号学生的糖果数量将比 i+1 号孩子的糖果数量多。
 * 具体地，以左规则为例：我们从左到右遍历该数组，假设当前遍历到位置 i，如果有 ratings[i - 1] < ratings[i] 那么 i 号学生的糖果数量将比 i−1 号孩子的糖果数量多，
 * 我们令 left[i]=left[i−1]+1 即可，否则我们令 left[i]=1。
 *
 */
public class LeetCode135 {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] left = new int[n];
        for (int i = 0; i < n; i++) {
            if (i > 0 && ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 1;
            }
        }
        int right = 0, ret = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (i < n - 1 && ratings[i] > ratings[i + 1]) {
                right++;
            } else {
                right = 1;
            }
            ret += Math.max(left[i], right);
        }
        return ret;
    }

    public int candy1(int[] ratings) {
        int n = ratings.length;
        int ret = 1;
        int inc = 1, dec=0, pre = 1;
        for (int i = 1; i < n; i++) {
            if(ratings[i] >= ratings[i-1]){
                dec = 0;
                pre = ratings[i] == ratings[i-1] ? 1:pre+1;
                ret +=pre;
                inc = pre;
            }else{
                dec++;
                if(dec == inc){
                    dec++;
                }
                ret += dec;
                pre=1;
            }
        }
        return ret;
    }
}

class LeetCode135_1 {
    /**
     * 两次遍历
     *      左规则：当 ratings[i - 1] < ratings[i] 时，i 号 糖果数量 > i - 1 号 糖果数量
     *      右规则：当 ratings[i] > ratings[i + 1] 时，i 号 糖果数量 > i + 1 号 糖果数量
     * @param ratings
     * @return
     */
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] left = new int[n];
        for (int i = 0; i < n; i++) {
            if(i > 0 && ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 1;
            }
        }
        int right = 0, ret = 0;
        for (int i = n - 1; i >= 0; i--) {
            if(i < n - 1 && ratings[i] > ratings[i + 1]) {
                right ++;
            } else {
                right = 1;
            }
            ret += Math.max(left[i], right);
        }
        return ret;
    }
}
