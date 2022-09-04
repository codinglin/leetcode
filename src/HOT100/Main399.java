package HOT100;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
* 并查集（不相交集合）用于处理连通性问题，最典型的应用是求解[最小生成树]的Kruskal算法
* 支持[查询(find)]、[合并(union)]操作
* 只回答两个结点是不是在一个连通分量中(也就是所谓的连通性问题),并不回答路径问题。
* 如果一个问题具有传递性质，可以考虑用并查集
* 并查集最常见的一种设计思想是：把同在一个连通分量中的结点组织成一个树形结构(代表元法)。
* 并查集使用[路径压缩]和[按秩合并]解决树的高度增加带来的[查询]性能消耗问题。
* */
public class Main399 {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int equationsSize = equations.size();
        UnionFind unionFind = new UnionFind(2 * equationsSize);
        // step 1: 预处理,将变量的值与id进行映射，使得并查集的底层使用数组实现,方便编码。
        Map<String, Integer> hashMap = new HashMap<>(2 * equationsSize);
        int id = 0;
        for (int i = 0; i < equationsSize; i++) {
            List<String> equation = equations.get(i);
            String var1 = equation.get(0);
            String var2 = equation.get(1);

            if(!hashMap.containsKey(var1)){
                hashMap.put(var1, id);
                id++;
            }
            if(!hashMap.containsKey(var2)){
                hashMap.put(var2, id);
                id++;
            }
            unionFind.union(hashMap.get(var1), hashMap.get(var2), values[i]);
        }

        // step 2: 做查询
        int queriesSize = queries.size();
        double[] res = new double[queriesSize];
        for(int i = 0; i<queriesSize; i++){
            String var1 = queries.get(i).get(0);
            String var2 = queries.get(i).get(1);
            Integer id1 = hashMap.get(var1);
            Integer id2 = hashMap.get(var2);
            if(id1 == null || id2 == null){
                res[i] = -1.0;
            }else {
                res[i] = unionFind.isConnected(id1, id2);
            }
        }
        return res;
    }

    private class UnionFind{

        private int[] parent;

        /**
         * 结点指向父结点的权值
         */
        private double[] weight;

        public UnionFind(int n) {
            this.parent = new int[n];
            this.weight = new double[n];
            for(int i=0; i<n; i++){
                parent[i] = i;
                weight[i] = 1.0d;
            }
        }

        public void union(int x, int y, double value){
            int rootX = find(x);
            int rootY = find(y);
            if(rootX == rootY){
                return;
            }
            parent[rootX] = rootY;
            weight[rootX] = weight[y] * value / weight[x];
        }

        /*
        * 路径压缩
        * @param x
        * @return 根结点的id
        * */
        public int find(int x){
            if(x!=parent[x]){
                int origin = parent[x];
                parent[x] = find(parent[x]);
                weight[x] *= weight[origin];
            }
            return parent[x];
        }

        public double isConnected(int x, int y){
            int rootX = find(x);
            int rootY = find(y);
            if(rootX == rootY){
                return weight[x] /weight[y];
            }else {
                return -1.0d;
            }
        }
    }
}
