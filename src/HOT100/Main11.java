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
