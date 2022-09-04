package problems;

public class JZOfferTwo32 {
    public static boolean isAnagram(String s, String t) {
        int nums[]=new int[32];
        boolean flag=false;
        if(s.length()!=t.length()) {
            return false;
        }else {
            for(int i=0;i<s.length();i++){
                nums[s.charAt(i)-97]++;
                nums[t.charAt(i)-97]--;
                if(s.charAt(i)!=t.charAt(i)){
                    flag=true;
                }
            }
        }
        for(int i=0;i< nums.length;i++){
            if(nums[i]!=0){
                return false;
            }
        }
        if(flag){
            return true;
        }else{
            return false;
        }
    }

    public static boolean isAnagramSolution(String s, String t) {
        if (s.length() != t.length() || s.equals(t)) {
            return false;
        }
        int[] arr = new int[26];
        for (char i:s.toCharArray()) {
            arr[i - 97]++;
        }
        for (char j:t.toCharArray()) {
            arr[j - 97]--;
            if (arr[j - 97] < 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s="nl", t = "cx";
        isAnagram(s,t);
    }
}
