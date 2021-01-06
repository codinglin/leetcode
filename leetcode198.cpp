#include <algorithm>
#include <iostream>
#include <vector>
using namespace std;

//动态规划
/*
    如果偷窃房屋大于2间
    对于第k间房屋，有两种选择
    1.偷窃第k间房屋，那么就不能偷窃第k-1间房屋，偷窃第k-2间房屋+之前k-2间偷取的金额数：
        当前最高总金额为dp[i-2]+num[i];
    2.不偷窃第k间房屋，则偷窃金额数为之前k-1间房屋的金额，为dp[i-1];
*/

int rob(vector<int> &nums)
{
    if(nums.empty()){
        return 0;
    }
    int n = nums.size();
    vector<int> dp(n, 0);
    if (n == 1)
    {
        return nums[0];
    }
    if (n == 2)
    {
        return max(nums[0], nums[1]);
    }
    dp[0] = nums[0];
    dp[1] = max(nums[0], nums[1]);
    for (int i = 2; i < n; i++)
    {
        dp[i] = max(dp[i - 2] + nums[i], dp[i - 1]);
    }
    return dp[n-1];
}

//[1,2,3,1]
//输出：4
int main()
{
    int n,x;
    scanf("%d", &n);
    vector<int> nums(n);
    for (int i = 0; i < n;i++){
        scanf("%d", &nums[i]);
    }
    x = rob(nums);
    printf("%d", x);
    return 0;
}