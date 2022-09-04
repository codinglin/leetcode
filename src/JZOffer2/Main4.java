package JZOffer2;

/*
* 由于数组中的元素都在int(即32位整数)范围内，因此我们可以依次计算答案的每一个二进制位是0还是1.
* 具体地,考虑答案的第i个二进制位(i从0开始编号),它可能为0或1.
* 对于数组中非答案的元素，每一个元素都出现了3次，对应着第i个二进制位的3个0或3个1，无论是哪一种情况，
* 它们的和都是3的倍数(即和为0或3)。
* 因此:答案的第i个二进制位就是数组中所有元素的第i个二进制位之和除以3的余数。
* */
public class Main4 {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for(int i=0; i<32; ++i){
            int total = 0;
            for(int num: nums){
                total += ((num >> i) & 1);
            }
            if(total % 3 !=0){
                ans |= (1 << i);
            }
        }
        return ans;
    }
}
