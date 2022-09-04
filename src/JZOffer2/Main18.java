package JZOffer2;

public class Main18 {
    public boolean isPalindrome(String s) {
        if(s.length()==1){
            return true;
        }
        String str = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length(); i++){
            if(Character.isLetterOrDigit(str.charAt(i))){
                sb.append(str.charAt(i));
            }
        }
        String ans = sb.toString();
        for(int i = 0; i < ans.length()/2; i++){
            if(ans.charAt(i)!=ans.charAt(ans.length()-1-i)){
                return false;
            }
        }
        return true;
    }
}

class Main18_1{
    public boolean isPalindrome(String s){
        int left = 0;
        int right = s.length() - 1;
        while (left <= right){
            if(!Character.isLetterOrDigit(s.charAt(left))){
                left++;
            }else if(!Character.isLetterOrDigit(s.charAt(right))){
                right--;
            }else {
                char char1 = Character.toLowerCase(s.charAt(left++));
                char char2 = Character.toLowerCase(s.charAt(right--));
                if(char1 != char2){
                    return false;
                }
            }
        }
        return true;
    }
}
