package JZOffer2;

public class Main12 {
    public static int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n];
        int[] rear = new int[n];
        for(int i=1; i<n; i++){
            pre[i] = pre[i-1] + nums[i-1];
        }
        for(int i=n-2; i>=0; i--){
            rear[i] = rear[i+1] + nums[i+1];
        }
        for(int i=0; i<n; i++){
            if(pre[i] == rear[i]){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 7, 3, 6, 5, 6};
        pivotIndex(nums);
    }
}
