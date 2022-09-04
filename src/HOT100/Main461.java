package HOT100;

public class Main461 {
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x^y);
    }
}

class Main461_1{
    public int hammingDistance(int x, int y){
        int s = x ^ y, ret = 0;
        while (s != 0){
            ret += s & 1;
            s >>= 1;
        }
        return ret;
    }
}
