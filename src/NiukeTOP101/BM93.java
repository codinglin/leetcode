package NiukeTOP101;

public class BM93 {
    public static int maxArea (int[] height) {
        if(height.length < 2){
            return 0;
        }
        int left = 0, right = height.length - 1;
        int maxArea = 0;
        while (left < right){
            int cur = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(maxArea, cur);
            if(height[left] < height[right]){
                left ++;
            }else{
                right --;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] height = new int[]{1,7,3,2,4,5,8,2,7};
        maxArea(height);
    }
}
