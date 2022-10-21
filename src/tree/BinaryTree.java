package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BinaryTree<E> {
    /**
     * 根结点
     */
    private TreeNode<E> root = null;

    /**
     * 建立二叉树时，用于缓存数据的栈空间
     */
    private LinkedList<E> stack = null;

    /**
     * 保存二叉树数据的列表
     */
    private List<E> elements = new ArrayList<>();

    /**
     * 无参构造方法
     */
    public BinaryTree(){
    }

    /**
     * 有参构造方法，默认左递归建立二叉树，
     * 因此需要传入左递归顺序的数据
     * @param data 左递归顺序的数组数据
     */
    public BinaryTree(E[] data){
        this.stack = new LinkedList<E>(Arrays.asList(data));
        CreateBinaryTree();
    }

    /**
     * 获取根结点
     * @return root 返回根结点
     */
    public TreeNode<E> getRoot(){
        return this.root;
    }

    /**
     * 设置根结点
     * @param root 根结点
     */
    public void setRoot(TreeNode<E> root){
        this.root = root;
    }

    /**
     * 左递归建立二叉树
     * @return
     */
    private void CreateBinaryTree(){
        if(!stack.isEmpty()){
            this.root = recursiveCreateBinaryTree(root, stack);
        }else{
            this.root = null;
        }
    }

    /***
     * 左递归建立二叉树，需要传入左递归顺序的二叉树数据
     * @param data
     */
    public void recursiveCreateBinaryTree(E[] data){
        this.stack = new LinkedList<E>(Arrays.asList(data));
        if(!stack.isEmpty()){
            this.root = recursiveCreateBinaryTree(this.root, this.stack);
        }else{
            this.root = null;
        }
    }
    /**
     * 左递归建立二叉树, 核心算法
     * @param node
     * @param stack
     * @return 返回根节点
     */
    private TreeNode<E> recursiveCreateBinaryTree(TreeNode<E> node, LinkedList<E> stack){
        if(!stack.isEmpty()){
            E value = stack.pop();
            if(value == null){
                node = null;
            }else{
                node = new TreeNode<>();
                node.val = value;
                node.left = recursiveCreateBinaryTree(node.left, stack);
                node.right = recursiveCreateBinaryTree(node.right, stack);
            }
        }else{
            return null;
        }
        return node;
    }


    /**
     * 层序建立二叉树，需要传入层序建立的二叉树数据
     * @param data 缓存数据的数组
     * @return
     */
    public void SequenceCreateBinaryTree(E[] data){
        this.stack = new LinkedList<E>(Arrays.asList(data));
        if(!stack.isEmpty()){
            root = SequenceCreateBinaryTree(root, stack);
        }else{
            root = new TreeNode<E>();
        }
    }

    /**
     * 层序建立二叉树，核心算法
     * @param rootNode 根节点
     * @return 返回根结点
     */
    private TreeNode<E> SequenceCreateBinaryTree(TreeNode<E> rootNode, LinkedList<E> stack){
        LinkedList<TreeNode> queue = new LinkedList<>();
        if(!stack.isEmpty()){
            rootNode = new TreeNode<>();
            rootNode.val = stack.pop();
            queue.addFirst(rootNode);
        }else{
            return null;
        }

        while (!stack.isEmpty()){
            TreeNode currentNode = queue.removeLast();
            E leftValue = stack.pop();
            TreeNode<E> leftNode = null;
            if(leftValue != null){
                leftNode = new TreeNode<>();
                leftNode.val = leftValue;
                queue.addFirst(leftNode);
            }
            currentNode.left = leftNode;
            E rightValue = stack.pop();
            TreeNode<E> rightNode = null;
            if(rightValue != null){
                rightNode = new TreeNode<>();
                rightNode.val = rightValue;
                queue.addFirst(rightNode);
            }
            currentNode.right = rightNode;
        }
        return rootNode;
    }


    /**
     * 先序遍历
     */
    public void preorder(){
        System.out.print("先序遍历：");
        this.preorder(root);
    }

    /**
     * 先序遍历
     * @param node
     */
    private void preorder(TreeNode<E> node){
        if(node == null){
            return;
        }
        System.out.print(node.val+" ");
        this.preorder(node.left);
        this.preorder(node.right);
    }

    /**
     * 后序遍历
     */
    public void postorder(){
        System.out.print("后序遍历：");
        this.postorder(root);
    }

    /**
     * 后序遍历
     * @param node
     */
    private void postorder(TreeNode<E> node){
        if(node == null){
            return;
        }
        this.postorder(node.right);
        this.postorder(node.left);
        System.out.print(node.val + " ");
    }

    /**
     * 中序遍历
     */
    public void inorder(){
        System.out.print("中序遍历：");
        this.inorder(this.root);
    }

    /**
     * 中序遍历
     * @param node
     */
    private void inorder(TreeNode<E> node){
        if(node == null){
            return;
        }
        this.inorder(node.left);
        System.out.print(node.val + " ");
        this.inorder(node.right);
    }

    /**
     * 获取二叉树数据元素
     * @return List 返回具有二叉树数据元素的列表
     */
    public List<E> getElements(){
        getElementList(root);
        return elements;
    }

    /**
     * 采用先序遍历的方式，获取二叉树数据元素
     * @param root 返回以左递归顺序的二叉树数据元素
     */
    private void getElementList(TreeNode<E> root){
        if(root == null){
            this.elements.add(null);
            return;
        }
        this.elements.add(root.val);
        getElementList(root.left);
        getElementList(root.right);
    }


    /**
     * 获取二叉树的最大深度
     * @return 二叉树深度
     */
    public int maxDepth(){
        return maxDepth(this.root);
    }

    /***
     * 获取该二叉树的深度
     * @param root
     * @return 返回二叉树深度
     */
    private int maxDepth(TreeNode root) {
        // 如果到达叶子节点返回0；
        if(root == null) {return 0;}
        // 左递归查找左子树深度
        int left = maxDepth(root.left);
        // 右递归查找右子树深度
        int right = maxDepth(root.right);
        // 返回最大深度并加1
        return Math.max(left, right) + 1;
    }

    @Override
    public String toString() {
        return "BinaryTree{" +
                "root=" + root +
                '}';
    }
}
