package NiukeTOP101;

public class BM52 {
    public int[] FindNumsAppearOnce (int[] array) {
        if(array.length <= 1){
            return new int[]{};
        }
        int res1 = 0, res2 = 0, temp = array[0];
        for (int i = 1; i < array.length; i++) {
            temp ^= array[i];
        }
        int k = 1;
        // 找到两个数不相同的第一位
        while ((k & temp) == 0){
            k <<= 1;
        }
        for(int i = 0; i < array.length; i++){
            //遍历数组，对每个数分类
            if((k & array[i]) == 0)
                res1 ^= array[i];
            else
                res2 ^= array[i];
        }
        //整理次序
        if(res1 < res2)
            return new int[] {res1, res2};
        else
            return new int[] {res2, res1};
    }
}
