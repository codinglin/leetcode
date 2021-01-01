#include <stdio.h>
#include <stdlib.h>

int* twoSum(int* nums, int numsSize, int target){
    int *result=(int*)malloc(sizeof(int)*2);
    for (int i = 0; i < numsSize-1; i++)
    {
        for (int j = i+1; j < numsSize; j++)
        {
            if(nums[i]+nums[j] == target){
                result[0]=i;
                result[1]=j;
                return result;
            }
        }
        
    }
    return result;
}

int main(){
    int nums[] = {0,2, 7, 11, 15,0};
    int target = 9;
    int* a=twoSum(nums,4,target);
    printf("%d %d",a[0],a[1]);
    return 0;
}