package problems;

public class LeetCode108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBST(int[] nums, int left, int right) {
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        if(left <= mid - 1) {
            root.left = sortedArrayToBST(nums, left, mid - 1);
        }
        if(right >= mid + 1) {
            root.right = sortedArrayToBST(nums, mid + 1, right);
        }
        return root;
    }
}
