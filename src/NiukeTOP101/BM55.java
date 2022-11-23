package NiukeTOP101;

import java.util.ArrayList;

public class BM55 {
    ArrayList<ArrayList<Integer>> ret = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<Integer> ans = new ArrayList<>();
        dfs(num, ans);
        return ret;
    }

    private void dfs(int[] num, ArrayList<Integer> ans) {
        if(ans.size() == num.length){
            ret.add(new ArrayList<>(ans));
            return;
        }
        for (int i = 0; i < num.length; i++) {
            if(ans.contains(num[i])){
                continue;
            }
            ans.add(num[i]);
            dfs(num, ans);
            ans.remove(ans.size() - 1);
        }
    }
}

class BM55_1{

    ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
    ArrayList<Integer> tempList = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        boolean[] numState = new boolean[num.length];
        backTracking(num, numState);
        return ret;
    }

    private void backTracking(int[] num, boolean[] numState) {
        if(tempList.size() == num.length){
            ret.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = 0; i < num.length; i++) {
            if(numState[i]){
                continue;
            }
            tempList.add(num[i]);
            numState[i] = true;
            backTracking(num, numState);
            tempList.remove(tempList.size() - 1);
        }
    }
}
