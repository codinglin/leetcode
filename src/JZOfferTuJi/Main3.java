package JZOfferTuJi;

public class Main3 {
    public int[] countBits(int n) {
        int[] bits = new int[n+1];
        for(int i=0; i<=n; i++){
            bits[i] = countOnes(i);
        }
        return bits;
    }

    private int countOnes(int x){
        int count = (x&1)==1? 1 : 0;
        while (x>0){
            if((x>>>1&1)==1){
                count++;
            }
        }
        return count;
    }
}


/*
   Brian Kernighan 算法
   原理：对于任意整数x，令x=x&(x-1),该运算将x的二进制表示的最后一个1变成0。
        因此，对x重复该操作,直到x变为0,则操作次数即为x的[一比特数]。
 */
class Main3_1{
    public int[] countBits(int n){
        int[] bits = new int[n+1];
        for(int i = 0; i<=n; i++){
            bits[i] = countOnes(i);
        }
        return bits;
    }

    private int countOnes(int x){
        int ones = 0;
        while (x > 0){
            x &= (x-1);
            ones++;
        }
        return ones;
    }
}


class Main3_2{

}
