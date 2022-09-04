package problems;

import java.util.*;

public class LeetCode49 {
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list=new ArrayList<>();
        if(strs.length==0){
            return list;
        }
        int count=0;
        Map hashMap=new HashMap();
        for(int i=0;i< strs.length;i++){
            char s[]=strs[i].toCharArray();
            Arrays.sort(s);
            String key=String.valueOf(s);
            if(hashMap.containsKey(key)){
                Integer value= (Integer) hashMap.get(key);
                List<String> x= list.get(value);
                x.add(strs[i]);
            }else {
                hashMap.put(key, count++);
                List<String> listCount = new ArrayList<>();
                listCount.add(strs[i]);
                list.add(listCount);
            }
        }
        return list;
    }

    public static List<List<String>> groupAnagramsSimple(String[] strs) {
        Map<String,List<String>> map=new HashMap<>();
        for(String str:strs){
            char[] array=str.toCharArray();
            Arrays.sort(array);
            String key=new String(array);
            List<String> list=map.getOrDefault(key,new ArrayList<String>());
            list.add(str);
            map.put(key,list);
        }
        return new ArrayList<List<String>>(map.values());
    }

    public static List<List<String>> groupAnagramsCount(String[] strs) {
        Map<String,List<String>> map=new HashMap<>();
        for(String str:strs){
            int counts[]=new int[26];
            int length=str.length();
            for(int i=0;i<length;i++){
                counts[str.charAt(i)-'a']++;
            }
            // 将每个出现次数大于 0 的字母和出现次数按顺序拼接成字符串，作为哈希表的键
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < 26; i++) {
                if (counts[i] != 0) {
                    sb.append((char) ('a' + i));
                    sb.append(counts[i]);
                }
            }
            String key = sb.toString();
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        groupAnagrams(strs);
    }
}
