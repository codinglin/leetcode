package HOT100;

import java.util.ArrayList;
import java.util.List;

public class Main39 {
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> list = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates.length==0){
            return res;
        }
        int index=0;
        backtrack(candidates, target, index);
        return res;
    }

    public void backtrack(int[] candidates, int target, int index){
        if(target==0){
            res.add(list);
            return;
        }
        if(target<0){
            return;
        }
        for(int i=index; i<candidates.length; i++){
            list.add(candidates[i]);
            backtrack(candidates,target-candidates[i], i);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target=7;
        Main39 main = new Main39();
        main.combinationSum(candidates, target);
    }
}
