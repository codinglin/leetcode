package tree;

public class TreeNode<E> {
    E val;
    TreeNode<E> left = null;
    TreeNode<E> right = null;
    TreeNode(){};
    TreeNode(E x){
        val = x;
    }
    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
