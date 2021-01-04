#include <iostream>
#include <algorithm>
using namespace std;

bool validPalindrome(string s,int left,int right){
    while (left<right)
    {
        if(s[left]!=s[right]){
            return false;
        }
        left++;
        right--;
    }
    return true;
}
//暴力解法
string longestPalindrome1(string s) {
    if(s.size() < 2){
        return s;
    }
    int begin, maxLen=1;
    for (int i = 0; i < s.size() - 1; i++){
        for (int j = i + 1; j < s.size();j++){
            if((j-i+1)>maxLen && validPalindrome(s,i,j)){
                begin = i;
                maxLen = j - i + 1;
            }
        }
    }
    return s.substr(begin, maxLen);
}



//中心扩散法
int expandAroundCenter(string s,int left,int right){
    // 当left=right时，回文中心是一个字符，回文串的长度是奇数
    // 当right=left+1时，此时回文中心有两个字符，回文串的长度为偶数
    int i = left, j = right;
    while (i>=0 && j<=s.length())
    {
        if(s[i]==s[j]){
            i--;
            j++;
        }else{
            break;
        }
    }
    //j-i+1-2=j-i-1
    return j - i - 1;
}

string longestPalindrome(string s) {
    if(s.size() < 2){
        return s;
    }
    int begin, maxLen=1,curMaxLen;
    for (int i = 0; i < s.size() - 1;i++){
        int oddNum = expandAroundCenter(s, i, i);
        int evenNum = expandAroundCenter(s, i, i + 1);
        int curMaxLen = max(oddNum, evenNum);
        if(curMaxLen>maxLen){
            maxLen = curMaxLen;
            begin = i - (maxLen - 1) / 2;
        }
    }
    return s.substr(begin, maxLen);
}


int main(){
    string x;
    x = longestPalindrome("babad");
    cout << x << endl;
    return 0;
}