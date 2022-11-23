package NiukeTOP101;

import java.util.Arrays;

/**
 * 候选法
 * 具体做法：
 *      初始化：候选人cond = -1， 候选人的投票次数cnt = 0
 *      遍历数组，如果cnt=0， 表示没有候选人，则选取当前数为候选人，++cnt
 *      否则，如果cnt > 0, 表示有候选人，如果当前数=cond，则++cnt，否则--cnt
 *      直到数组遍历完毕，最后检查cond是否为众数
 */
public class BM51 {
    public int MoreThanHalfNum_Solution(int [] array) {
        int cond = -1, cnt = 0;
        for (int i = 0; i < array.length; i++) {
            if(cnt == 0){
                cond = array[i];
                cnt ++;
            }else if(cond == array[i]){
                cnt ++;
            } else if (cond != array[i]) {
                cnt --;
            }
        }
        return cond;
    }
}
