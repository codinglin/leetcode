package featuredTop;

public class LeetCode7 {
    public int reverse(int x) {
        int res = 0;
        while (x != 0){
            int temp = x % 10;
            //判断是否 大于 最大32位整数
            if (res>214748364 || (res==214748364 && temp>7)) {
                return 0;
            }
            //判断是否 小于 最小32位整数
            if (res<-214748364 || (res==-214748364 && temp<-8)) {
                return 0;
            }
            res = res * 10 + temp;
            x = x / 10;
        }
        return res;
    }
}
