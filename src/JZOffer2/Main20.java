package JZOffer2;

public class Main20 {
    public int countSubstrings(String s) {
        int length = s.length();
        int count = 0, left, right;
        int i = 0;
        while(i < 2 * length - 1){
            left = i / 2;
            right = i / 2 + i % 2;
            while (left>=0 && right<length){
                if(s.charAt(left)==s.charAt(right)){
                    count++;
                    left--;
                    right++;
                }else{
                    break;
                }
            }
            i++;
        }
        return count;
    }
}
