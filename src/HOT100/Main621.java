package HOT100;

import java.util.*;

public class Main621 {

    // 62/71仍有错误
    public static int leastInterval(char[] tasks, int n) {
        int length = tasks.length;
        if(n==0){
            return length;
        }
        int[] num = new int[32];
        for(int i=0; i<length; i++){
            num[tasks[i]-'A']++;
        }
        int pair;
        int time=0;
        int count;
        while (length>0){
            pair = n;
            count = 0;
            boolean flag = false;
            for(int i=0; i<num.length && pair>=0; i++){
                if(num[i]>0){
                    length--;
                    pair--;
                    count++;
                    num[i]--;
                    if(num[i]>0){
                        flag=true;
                    }
                }
            }
            if(flag==false){
                time+=count;
            }else{
                time = count+pair+time+1;
            }
        }
        return time;
    }

    public static void main(String[] args) {
        char[] tasks = new char[]{'A','B','A'};
        leastInterval(tasks, 2);
    }
}


/*
* 如果当前多种任务不在冷却中，那么我们应该如何挑选执行的任务呢？
* 直觉上，我们应当选择剩余执行次数最多的那个任务，将每种任务的剩余执行次数尽可能平均，使得CPU处于待命状态的时间尽可能少。
* 用二元组(nextValid_i,rest_i)表示第i个任务，其中nextValid_i表示其因冷却限制，最早可以执行的时间
*         rest_i表示其剩余执行次数。初始时，所有的nextValid_i均为1，而rest_i即为任务i在数组tasks中出现的次数。
* 用time记录当前的时间。需要选择不在冷却中并且剩余执行次数最多的那个任务。
*   需要找到满足nextValid_i<=time的并且rest_i最大的索引i。
* 只需要遍历所有的二元组，即可找到i。
* 在这之后，我们将(nextValid_i,rest_i)更新为(time+n+1, rest_1 -1)
* 记录任务i下一次冷却结束的时间以及剩余执行次数。
* 如果更新后的rest_i=0，那么任务i全部做完。
* 而对于time的更新，我们可以选择将其不断增加1，模拟每一个时间片。
* 我们可以在每一次遍历之前，将time更新为所有nextValid_i中的最小值，直接[跳过]待命状态，
*   保证每一次对二元组的遍历都是有效地。
* 需要注意的是，只有当这个最小值大于time时，才需要这样快速更新。
* */
class Main621_1{
    public static int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> freq = new HashMap<>();
        for(char ch: tasks){
            freq.put(ch, freq.getOrDefault(ch, 0) +1);
        }

        // 任务总数
        int m = freq.size();
        List<Integer> nextValid = new ArrayList<>();
        List<Integer> rest = new ArrayList<>();
        Set<Map.Entry<Character, Integer>> entrySet = freq.entrySet();
        for(Map.Entry<Character, Integer> entry: entrySet){
            int value = entry.getValue();
            nextValid.add(1);
            rest.add(value);
        }
        int time = 0;
        for(int i=0; i< tasks.length; ++i){
            ++time;
            int minNextValid = Integer.MAX_VALUE;
            for(int j=0; j<m; ++j){
                if(rest.get(j)!=0){
                    minNextValid = Math.min(minNextValid, nextValid.get(j));
                }
            }
            time = Math.max(time, minNextValid);
            int best = -1;
            for(int j=0; j<m; ++j){
                if(rest.get(j)!=0 && nextValid.get(j)<=time){
                    if(best==-1 || rest.get(j)>rest.get(best)){
                        best = j;
                    }
                }
            }
            nextValid.set(best, time+n+1);
            rest.set(best, rest.get(best)-1);
        }
        return time;
    }

    public static void main(String[] args) {
        char[] tasks = new char[]{'A','A','A','B','B','B', 'C','C','C', 'D', 'D', 'E'};
        leastInterval(tasks, 2);
    }
}


class Main621_2{
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        int length = tasks.length;
        for(int i=0; i<length; i++){
            freq[tasks[i]-'A']++;
        }
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        for(char ch: tasks){
            max = Math.max(max, map.getOrDefault(ch, 0) +1);
            map.put(ch, map.getOrDefault(ch, 0) +1);
        }
        Set<Map.Entry<Character, Integer>> entrySet = map.entrySet();
        int count = 0;
        for(Map.Entry<Character, Integer> entry: entrySet){
            int value = entry.getValue();
            if(max == value){
                count++;
            }
        }
        int time = (n+1) * (max-1) + count;
        return Math.max(length, time);
    }
}


class Main621_3{
    public int leastInterval(char[] tasks, int n) {
       int res = 0;
       Map<Character, Integer> map = new HashMap<>(32);
       for(char ch: tasks){
           map.merge(ch, 1, Integer::sum);
       }
       // 大顶堆
       PriorityQueue<Map.Entry<Character, Integer>> priorityQueue =
               new PriorityQueue<>(map.size(), (a, b) -> b.getValue() - a.getValue());
       priorityQueue.addAll(map.entrySet());
       // 暂存list
       ArrayList<Map.Entry<Character, Integer>> tmpList = new ArrayList<>();
       int k = 0;
       while (!priorityQueue.isEmpty()){
           // 初始化每轮调度的时间间隔
           k = n + 1;
           tmpList.clear();
           while (!priorityQueue.isEmpty() && k>0){
               Map.Entry<Character, Integer> entry = priorityQueue.poll();
               k--;
               entry.setValue(entry.getValue() - 1);
               // 如果任务还未结束，暂存起来，后面继续加入待调度堆
               if(entry.getValue()!=0){
                   tmpList.add(entry);
               }
           }
           // 未结束的任务继续加入待调整堆
           priorityQueue.addAll(tmpList);
           // 完成一轮调度增加n+1时间
           res = res + n + 1;
       }
       // -k 补偿最后一轮多加的空间隔
       return res - k;
    }
}