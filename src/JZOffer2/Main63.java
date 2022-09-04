package JZOffer2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main63 {
    public static String replaceWords(List<String> dictionary, String sentence) {
        String[] str = sentence.split(" ");
        List<String> list = new ArrayList<>(dictionary);
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        for(int i = 0; i < str.length; i++){
            for(int j = 0; j < list.size(); j++){
                if(str[i].startsWith(list.get(j))){
                    str[i] = list.get(j);
                    break;
                }
            }
        }
        String result = "";
        for (String s : str) {
            result += s + " ";
        }
        return result.substring(0, result.length()-1);
    }

    public static void main(String[] args) {
        List<String> dictionary = Arrays.asList(new String[]{"a","b","c"});
        String sentence = "aadsfasf absbs bbab cadsfafs";
        replaceWords(dictionary, sentence);
    }
}

class Main63_1{
    class TrieNode{
        TrieNode[] kids;
        boolean isValid;
        public TrieNode(){
            kids = new TrieNode[26];
        }
    }

    TrieNode root = new TrieNode();

    public String replaceWords(List<String> dictionary, String sentence){
        String[] words = new String[dictionary.size()];
        for(int i = 0; i < words.length; i++){
            words[i] = dictionary.get(i);
        }
        // 建树过程
        for(String word : words){
            insert(root, word);
        }
        String[] str = sentence.split(" ");
        for(int i = 0; i < str.length; i++){
            // 如果可以在树中找到对应单词的前缀，那么将这个单词替换为它的前缀
            if(search(root, str[i])){
                str[i] = replace(str[i], root);
            }
        }
        // 用StringBuilder来把字符串数组还原成原字符串句子的转换目标字符串
        StringBuilder sb = new StringBuilder();
        for (String s : str) {
            sb.append(s).append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    // 建前缀树模板
    public void insert(TrieNode root, String s){
        TrieNode node = root;
        for(char ch : s.toCharArray()){
            if(node.kids[ch - 'a'] == null){
                node.kids[ch - 'a'] = new TrieNode();
            }
            node = node.kids[ch - 'a'];
        }
        node.isValid = true;
    }

    // 查询是否存在传入的字符串的前缀
    public boolean search(TrieNode root, String s){
        TrieNode node = root;
        for(char ch : s.toCharArray()){
            if(node.isValid == true) break;
            if(node.kids[ch - 'a'] == null) return false;
            node = node.kids[ch - 'a'];
        }
        return true;
    }

    // 将传入的字符串替换为它在前缀树中的前缀字符串
    public String replace(String s, TrieNode root){
        TrieNode node = root;
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()){
            if(node.isValid || node.kids[ch - 'a'] == null){
                break;
            }
            node = node.kids[ch - 'a'];
            sb.append(ch);
        }
        return sb.toString();
    }
}
