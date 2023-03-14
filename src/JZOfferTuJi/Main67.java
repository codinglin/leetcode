package JZOfferTuJi;

import java.util.HashSet;
import java.util.Set;

// 哈希表
public class Main67 {
    // 最高位的二进制位编号为 30
    static final int HIGH_BIT = 30;

    public int findMaximumXOR(int[] nums) {
        int x = 0;
        for (int k = HIGH_BIT; k >= 0; k--){
            Set<Integer> seen = new HashSet<>();
            // 将所有的 pre^k(a_j) 放入哈希表中
            for (int num : nums) {
                // 如果只想保留从最高位开始到第 k 个二进制位为止的部分，只需将其右移 k 位
                seen.add(num >> k);
            }
            // 目前 x 包含从最高位开始到第 k+1 个二进制为止的部分
            // 将 x 的第 k 个二进制位置为 1，即为 x = x * 2 + 1
            int xNext = x * 2 + 1;
            boolean found = false;
            for (int num : nums) {
                if (seen.contains(xNext ^ (num >> k))){
                    found = true;
                    break;
                }
            }
            if (found){
                x = xNext;
            } else {
                // 如果没有找到满足等式的 a_i 和 a_j，那么 x 的第 k 个二进制位只能为 0, 即为 x = x * 2
                x = xNext - 1;
            }
        }
        return x;
    }
}

// 字典树
class Main67_1{
    // 字典树的根节点
    Trie2 root = new Trie2();
    // 最高位的二进制位编号为 30
    static final int HIGH_BIT = 30;

    public int findMaximumXOR(int[] nums){
        int n = nums.length;
        int x = 0;
        for(int i = 1; i < n; i++){
            // 将 num[i-1] 放入字典树，此时nums[0 .. i-1] 都在字典树中
            add(nums[i-1]);
            // 将nums[i]看作a_i，找出最大的x更新答案
            x = Math.max(x, check(nums[i]));
        }
        return x;
    }

    public void add(int num){
        Trie2 cur = root;
        for(int k = HIGH_BIT; k>=0; k--){
            int bit = (num >> k) & 1;
            if(bit == 0){
                if(cur.left == null){
                    cur.left = new Trie2();
                }
                cur = cur.left;
            }else {
                if(cur.right == null){
                    cur.right = new Trie2();
                }
                cur = cur.right;
            }
        }
    }

    public int check(int num){
        Trie2 cur = root;
        int x = 0;
        for(int k = HIGH_BIT; k>=0; k--){
            int bit = (num >> k) & 1;
            if(bit == 0){
                // a_i 的第k个二进制位为0，应当往表示1的子节点right走
                if(cur.right != null){
                    cur = cur.right;
                    x = x * 2 + 1;
                }else {
                    cur = cur.left;
                    x = x * 2;
                }
            }else{
                // a_i 的第k个二进制位为1，应当往表示0的子节点left走
                if(cur.left != null){
                    cur = cur.left;
                    x = x * 2 + 1;
                }else {
                    cur = cur.right;
                    x = x * 2;
                }
            }
        }
        return x;
    }
}

class Trie2{
    // 左子树指向表示 0 的子节点
    Trie2 left = null;
    Trie2 right = null;
}
