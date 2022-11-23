package NiukeTOP101;

import java.util.ArrayList;
import java.util.Arrays;

public class BM56 {
    ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
    ArrayList<Integer> ans = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        Arrays.sort(num);
        boolean[] numState = new boolean[num.length];
        dfs(num, numState);
        return ret;
    }

    private void dfs(int[] num, boolean[] numState) {
        if(ans.size() == num.length){
            ret.add(new ArrayList<>(ans));
            return;
        }
        for (int i = 0; i < num.length; i++) {
            if(numState[i]){
                continue;
            }
            if(i >= 1 && num[i] == num[i-1] && numState[i-1]){
                continue;
            }
            ans.add(num[i]);
            numState[i] = true;
            dfs(num, numState);
            numState[i] = false;
            ans.remove(ans.size() - 1);
        }
    }
}
