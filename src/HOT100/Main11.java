package HOT100;

public class Main11 {
    public int maxArea(int[] height) {
        int n = height.length;
        int start=0, end=n-1;
        int maxRL=0, area;
        while(start<end){
            area = (end-start) * Math.min(height[start], height[end]);
            if(area>maxRL){
                maxRL = area;
            }
            if(height[start]<height[end]){
                start++;
            }else{
                end--;
            }
        }
        return maxRL;
    }

    public static void main(String[] args) {

    }
}

class Main11_1 {
    public int maxArea(int[] height) {
        int n = height.length;
        int left = 0, right = n - 1, max = 0;
        while (left < right) {
            max = Math.max(max, Math.min(height[left], height[right]) * (right - left));
            if(height[left] < height[right]) {
                left ++;
            } else {
                right --;
            }
        }
        return max;
    }
}
