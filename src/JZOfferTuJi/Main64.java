package JZOfferTuJi;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main64 {
    /** Initialize your data structure here. */
    // 存放字典单词
    Set<String> words;

    // 记录字典中所有广义邻居对应的个数
    Map<String, Integer> neighborCount;

    public Main64() {
        words = new HashSet<>();
        neighborCount = new HashMap<>();
    }

    // 生成一个单词所有的广义邻居
    public String[] getNeighbors(String word){
        // 广义邻居的个数 = 字符串的长度
        String[] neighbors = new String[word.length()];
        StringBuilder str = new StringBuilder(word);
        // 修改字符串中的各位上的字符来生成广义邻居
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            str.setCharAt(i, '*');
            neighbors[i] = str.toString();
            str.setCharAt(i, c);
        }
        return neighbors;
    }

    // 构建字典
    public void buildDict(String[] dictionary) {
        // 统计字典中所有单词的广义邻居数
        for(String word : dictionary){
            // 将字典单词加入哈希表中，方便后面查验插入的字符是否已经在单词表中
            words.add(word);
            for(String neighbor : getNeighbors(word)){
                neighborCount.put(neighbor, neighborCount.getOrDefault(neighbor, 0) + 1);
            }
        }
    }

    // 在字典中查找是否存在广义邻居
    public boolean search(String searchWord) {
        // 查找所有广义邻居
        for(String neighbor : getNeighbors(searchWord)){
            int neighborNum = neighborCount.getOrDefault(neighbor, 0);
            if(neighborNum > 1 || neighborNum == 1 && !words.contains(searchWord)){
                return true;
            }
        }
        return false;
    }
}
