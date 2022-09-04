package HOT100;

import java.util.ArrayList;
import java.util.List;

public class Main279 {
    // BFS
    public int numSquaresBFS(int n) {
        List<Integer> storage = new ArrayList<>();
        int ret = 1;
        for(int i =0; i*i <=n; i++){
            storage.add(i*i);
        }
        List<Integer> arr = new ArrayList<>();
        arr.add(n);
        while (!arr.isEmpty()){
            List<Integer> arrList = new ArrayList<>();
            for(int i=0; i<arr.size(); i++){
                if(storage.contains(arr.get(i))){
                    return ret;
                }else{
                    for(int value: storage){
                        if(value > arr.get(i)){
                            break;
                        }
                        arrList.add(arr.get(i)-value);
                    }
                }
            }
            ret++;
            arr=arrList;
        }
        return ret;
    }

    // 贪心
    public int numSquaresGreedy(int n){
        List<Integer> storage = new ArrayList<>();
        int ret = 1;
        for(int i =0; i*i <=n; i++){
            storage.add(i*i);
        }
        while (ret<=4){
            if(divisible(ret, n, storage)){
                return ret;
            }
            ret++;
        }
        return ret;
    }

    private boolean divisible(int count, int value, List<Integer> storage){
        if(count==1){
            return storage.contains(value);
        }else{
            for(int val: storage){
                if(divisible(count-1, value-val, storage)){
                    return true;
                }
            }
            return false;
        }
    }

    //DP
    public int numSquaresDP(int n){
        int[] dp = new int[n+1];
        for(int i=1; i<=n; i++){
            dp[i] = i;
            for(int j=1; i-j*j>=0; j++){
                dp[i]=Math.min(dp[i], dp[i-j*j]+1);
            }
        }
        return dp[n];
    }
}
