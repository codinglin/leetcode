package NiukeTOP101;

public class BM86 {
    public String solve (String s, String t) {
        StringBuilder rev_s = new StringBuilder(s).reverse();
        StringBuilder rev_t = new StringBuilder(t).reverse();
        StringBuilder result = new StringBuilder();
        int s_length = s.length();
        int t_length = t.length();
        int min = Math.min(s_length, t_length);
        int carry = 0, s_index = 0, t_index = 0;
        while (min-- > 0){
            int sum = (rev_s.charAt(s_index) - '0' + rev_t.charAt(t_index) - '0' + carry) % (10);
            carry = (rev_s.charAt(s_index) - '0' + rev_t.charAt(t_index) - '0' + carry) / (10);
            result.append(sum);
            s_index++;
            t_index++;
        }
        while (s_index < s.length()){
            int sum = (rev_s.charAt(s_index) - '0' + carry) % (10);
            carry = (rev_s.charAt(s_index) - '0' + carry) / (10);
            result.append(sum);
            s_index++;
        }
        while (t_index < t.length()){
            int sum = (rev_t.charAt(t_index) - '0' + carry) % (10);
            carry = (rev_t.charAt(t_index) - '0' + carry) / (10);
            result.append(sum);
            t_index++;
        }
        if(carry!=0){
            result.append(carry);
        }
        return result.reverse().toString();
    }
}
