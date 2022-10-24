package JZOffer;

import java.util.*;

public class Main38 {
    Set<String> rec;
    boolean[] visited;

    public String[] permutation(String s) {
        int n = s.length();
        rec = new HashSet<>();
        visited = new boolean[n];
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        StringBuffer perm = new StringBuffer();
        backtrack(arr, 0, n, perm);
        return rec.stream().toArray(String[]::new);
    }

    private void backtrack(char[] arr, int i, int n, StringBuffer perm) {
        if(i == n){
            rec.add(perm.toString());
            return;
        }
        for (int j = 0; j < n; j++) {
            if(!visited[j]){
                visited[j] = true;
                perm.append(arr[j]);
                backtrack(arr, i+1, n, perm);
                perm.deleteCharAt(perm.length() - 1);
                visited[j] = false;
            }
        }
    }
}
