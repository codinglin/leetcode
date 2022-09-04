package problems;

public class LeetCode66 {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int[] newDigits = new int[n+1];
        digits[n-1]+=1;
        int add=0;
        boolean flag=false;
        for(int i=n-1; i>=0; i--){
            digits[i]+=add;
            if(digits[0]>=10){
                flag=true;
            }
            if(digits[i]>=10){
                digits[i]%=10;
                add=1;
            }else{
                add=0;
            }
            newDigits[i+1]=digits[i];
        }
        if(flag){
            newDigits[0]=1;
            return newDigits;
        }else{
            return digits;
        }
    }
    public int[] plusOne1(int[] digits) {
        for(int i=digits.length-1; i>=0; i--){
            digits[i]++;
            digits[i] = digits[i]%10;
            if(digits[i]!=0) return digits;
        }
        digits = new int[digits.length+1];
        digits[0]=1;
        return digits;
    }
}
