package NiukeTOP101;

public class BM21 {
    public int minNumberInRotateArray(int [] array) {
        int left = 0;
        int right = array.length - 1;
        while(left < right){
            int mid = (left + right) / 2;
            //最小的数字在mid右边
            if(array[mid] > array[right])
                left = mid + 1;
                //无法判断，一个一个试
            else if(array[mid] == array[right])
                right--;
                //最小数字要么是mid要么在mid左边
            else
                right = mid;
        }
        return array[left];
    }
}
