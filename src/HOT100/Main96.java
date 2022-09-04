package HOT100;

public class Main96 {
    public int numTrees(int n) {
        int[] g = new int[n+1];
        g[0]=1;
        g[1]=1;
        for(int i=2; i<=n; i++){
            for(int j=1; j<=i; j++){
                g[i] += g[j-1] * g[i-j];
            }
        }
        return g[n];
    }

    // 卡塔兰数
    public int numTrees1(int n) {
        // 提示：我们在这里需要用 long 类型防止计算过程中的溢出
        long C = 1;
        for (int i = 0; i < n; ++i) {
            C = C * 2 * (2 * i + 1) / (i + 2);
        }
        return (int) C;
    }

    public static void main(String[] args) {

    }
}
