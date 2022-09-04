package HOT100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 深度优先遍历
public class Main207 {
    List<List<Integer>> edges;
    int[] visited;
    boolean valid = true;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<>();
        for (int i=0; i<numCourses; i++){
            edges.add(new ArrayList<>());
        }
        for(int[] info: prerequisites){
            edges.get(info[1]).add(info[0]);
        }
        visited = new int[numCourses];
        for(int i=0; i<numCourses && valid; i++){
            if(visited[i]==0){
                dfs(i);
            }
        }
        return valid;
    }

    public void dfs(int i){
        visited[i] = 1;
        for(int v: edges.get(i)){
            if(visited[v] == 0){
                dfs(v);
                if(!valid){
                    return;
                }
            } else if(visited[v] == 1){
                valid = false;
                return;
            }
        }
        visited[i] = 2;
    }
}


// 广度优先遍历
class Main207_1{
    List<List<Integer>> edges;
    int[] indeg;

    public boolean canFinish(int numCourses, int[][] prerequisites){
        edges = new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            edges.add(new ArrayList<>());
        }
        int[] indeg = new int[numCourses];
        for(int[] info: prerequisites){
            edges.get(info[1]).add(info[0]);
            ++indeg[info[0]];
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<numCourses; i++){
            if(indeg[i] == 0){
                queue.offer(i);
            }
        }
        int visited = 0;
        while (!queue.isEmpty()){
            visited++;
            int u = queue.poll();
            for(int v: edges.get(u)){
                --indeg[v];
                if (indeg[v] == 0){
                    queue.offer(v);
                }
            }
        }
        return visited == numCourses;
    }
}
