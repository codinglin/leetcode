package JZOffer;

import java.util.Stack;

/**
 * 方法一：递归分治
 */
public class Main33 {
    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder, 0, postorder.length-1);
    }

    boolean recur(int[] postorder, int i, int j){
        if(i >= j) return true;
        int p = i;
        while(postorder[p] < postorder[j]) p++;
        int m = p;
        while(postorder[p] > postorder[j]) p++;
        return p == j && recur(postorder, i, m-1) && recur(postorder, m, j-1);
    }
}

/**
 * 辅助单调栈
 * 后续遍历倒序：[根结点|右子树|左子树]。类似先序遍历镜像，即先序遍历为"根、左、右"的顺序
 */
class Main33_1{
    public boolean verifyPostorder(int[] postorder) {
        Stack<Integer> stack = new Stack<>();
        int root = Integer.MAX_VALUE;
        for(int i = postorder.length - 1; i >= 0; i--) {
            if(postorder[i] > root) return false;
            while(!stack.isEmpty() && stack.peek() > postorder[i])
                root = stack.pop();
            stack.add(postorder[i]);
        }
        return true;
    }
}
