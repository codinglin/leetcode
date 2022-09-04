package problems;

public class LeetCode58 {
    public static int lengthOfLastWord(String s) {
        String[] c = s.trim().split(" +");
        return c[c.length-1].length();
    }

    public static void main(String[] args) {
        String s = "   fly me   to   the moon  ";
        lengthOfLastWord(s);
    }
}
