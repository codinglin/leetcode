package problems;

public class LeetCode338 {
    public int[] countBits(int n) {
        int v[]=new int [n+1];
        v[0]=0;
        for(int i=1;i<=n;i++){
            v[i]=v[i>>1]+i/2;
        }
        return v;
    }

    public static void main(String[] args) {

    }
}
