package JZOffer2;

import java.util.HashMap;
import java.util.Map;

public class Main5 {
    // 暴力
    public int maxProduct(String[] words) {
        int maxLength = 0;
        int n = words.length;
        for(int i=0; i<n; i++){
            String word1 = words[i];
            for(int j=i+1; j<n; j++){
                String word2 = words[j];
                if(!hasSameChar(word1, word2)){
                    maxLength = Math.max(maxLength, word1.length() * word2.length());
                }
            }
        }
        return maxLength;
    }

    private boolean hasSameChar(String word1, String word2) {
        int[] count = new int[26];
        for (char c: word1.toCharArray()) count[c - 'a'] = 1;
        for (char c: word2.toCharArray()){
            if(count[c - 'a'] == 1)
                return true;
        }
        return false;
    }
}

class Main5_1{
    // 位运算优化,优化时间复杂度,看是否出现了重复计算。可以将运算过的每个单词的bitMask存储在数组中。
    public int maxProduct(String[] words) {
        int n = words.length;
        int[] masks = new int[n];
        for(int i=0; i<n; i++){
            int bitMask = 0;
            for(char c: words[i].toCharArray()){
                bitMask |= (1 << (c - 'a'));
            }
            masks[i] = bitMask;
        }
        int maxLength = 0;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if((masks[i] & masks[j]) == 0){
                    maxLength = Math.max(maxLength, words[i].length() * words[j].length());
                }
            }
        }
        return maxLength;
    }

    private boolean hasSameChar(String word1, String word2) {
        int bitMask1 = 0, bitMask2 = 0;
        for(char c: word1.toCharArray()) bitMask1 |= 1 << (c - 'a');
        for(char c: word2.toCharArray()) bitMask2 |= 1 << (c - 'a');
        return (bitMask1 & bitMask2) != 0;
    }
}

class Main5_2{
    public int maxProduct(String[] words) {
        int n = words.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            int bitMask = 0;
            for(char c: words[i].toCharArray()){
                bitMask |= (1 << (c - 'a'));
            }
            map.put(bitMask, Math.max(map.getOrDefault(bitMask, 0), words[i].length()));
        }
        int maxLength = 0;
        for(int x: map.keySet()){
            for(int y: map.keySet()){
                if((x & y) == 0){
                    maxLength = Math.max(maxLength, map.get(x) * map.get(y));
                }
            }
        }
        return maxLength;
    }
}
