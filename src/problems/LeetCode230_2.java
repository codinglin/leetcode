package problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LeetCode230_2 {
    public int kthSmallest(TreeNode root, int k){
        // 中序遍历生成数值列表
        List<Integer> inorderList = new ArrayList<>();
        inorder(root, inorderList);
        return 0;
    }

    private void inorder(TreeNode node, List<Integer> inorderList){
        if(node.left != null){
            inorder(node.left, inorderList);
        }
        inorderList.add(node.val);
        if(node.right != null){
            inorder(node.right, inorderList);
        }
    }

    private void shuffle(int[] arr){
        Random random = new Random();
        int length = arr.length;
        for(int i = 0; i < length; i++) {
            int randIndex = random.nextInt(length);
            int temp = arr[i];
            arr[i] = arr[randIndex];
            arr[randIndex] = temp;
        }
    }
}
