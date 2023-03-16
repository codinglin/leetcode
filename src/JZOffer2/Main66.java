package JZOffer2;

public class Main66 {
    public int[] constructArr(int[] a) {
        if(a.length == 0) {
            return new int[]{};
        }
        int sum = 1, countZero = 0, index = 0;
        for (int i = 0; i < a.length; i++) {
            sum *= a[i];
            if(a[i] == 0) {
                countZero ++;
                index = i;
            }
        }
        int[] b = new int[a.length];
        if(countZero > 1) {
            return b;
        } else if(countZero == 1) {
            sum = 1;
            for (int i = 0; i < a.length; i++) {
                if(i != index) {
                    sum *= a[i];
                }
            }
            b[index] = sum;
            return b;
        }
        for (int i = 0; i < a.length; i++) {
            b[i] = sum / a[i];
        }
        return b;
    }
}

class Main66_1 {
    public int[] productExceptSelf(int[] a) {
        int length = a.length;

        // L 和 R 分别表示左右两侧的乘积列表
        int[] L = new int[length];
        int[] R = new int[length];

        int[] answer = new int[length];

        // L[i] 为索引 i 左侧所有元素的乘积
        // 对于索引为 '0' 的元素，因为左侧没有元素，所以 L[0] = 1
        L[0] = 1;
        for (int i = 1; i < length; i++) {
            L[i] = a[i - 1] * L[i - 1];
        }

        // R[i] 为索引 i 右侧所有元素的乘积
        // 对于索引为 'length-1' 的元素，因为右侧没有元素，所以 R[length-1] = 1
        R[length - 1] = 1;
        for (int i = length - 2; i >= 0; i--) {
            R[i] = a[i + 1] * R[i + 1];
        }

        // 对于索引 i，除 a[i] 之外其余各元素的乘积就是左侧所有元素的乘积乘以右侧所有元素的乘积
        for (int i = 0; i < length; i++) {
            answer[i] = L[i] * R[i];
        }

        return answer;
    }
}
