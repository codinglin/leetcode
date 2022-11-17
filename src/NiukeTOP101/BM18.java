package NiukeTOP101;

public class BM18 {
    public boolean Find(int target, int [][] array) {
        int m = array.length;
        if(m == 0) return false;
        int n = array[0].length;
        if(n == 0) return false;
        int r = 0, c = n-1; // 右上角元素
        while (r < m && c >= 0){
            if(target == array[r][c]){
                return true;
            }else if(target > array[r][c]){
                ++r;
            }else {
                --c;
            }
        }
        return false;
    }
}
