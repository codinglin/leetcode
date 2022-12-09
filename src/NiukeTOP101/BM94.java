package NiukeTOP101;

public class BM94 {
    public long maxWater (int[] arr) {
        if(arr.length < 3){
            return 0;
        }
        int left = 0, right = arr.length - 1;
        int leftBoundary = 0, rightBoundary = 0;
        int capacity = 0;
        while (left < right){
            leftBoundary = Math.max(arr[left], leftBoundary);
            rightBoundary = Math.max(arr[right], rightBoundary);
            if(leftBoundary > rightBoundary){
                capacity += rightBoundary - arr[right--];
            }else{
                capacity += leftBoundary - arr[left++];
            }
        }
        return capacity;
    }
}
