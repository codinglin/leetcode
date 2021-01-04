#include <unordered_set>
#include <unordered_map>
#include <iostream>
using namespace std;

//同步测试
int lengthOfLongestSubstring(string s){
    if(s.size()==0)
        return 0;
    unordered_set<char> lookup;
    int maxStr = 0;
    int left = 0, i;
    for (i = 0; i < s.size();i++){
        /* 
            find在当前集合中查找等于key值的元素，并返回指向该元素的迭代器；如果没有找到，返回指向集合最后一个元素的迭代器。
            如果s[i]存在于set集合中，则子串中有重复值，此时需要滑动窗口，删除集合中s[left],并让left++;
            为什么使用while呢？
            是因为使其循环直至s[i]的元素与set中的相同元素从set中删除
            直到缩小到一个没有重复的连续元素的区间
        */
        while (lookup.find(s[i]) != lookup.end()){  
            lookup.erase(s[left]);
            left ++;
        }
        //最大长度，就是当前位置减去区间的最左端（即left),不要忘了+1。
        maxStr = max(maxStr,i-left+1);
        lookup.insert(s[i]);
    }
    return maxStr;
}

int lengthOfLongestSubstring1(string s){
    if(s.size()==0)
        return 0;
    int maxStr = 0;
    int left = 0, i;
    for (i = 0; i < s.size();i++){
        
    }
    return maxStr;
}

int main(){
    int x=lengthOfLongestSubstring("abcabcbb");
    printf("%d", x);
    return 0;
}