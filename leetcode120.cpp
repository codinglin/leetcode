#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int minimumTotal(vector<vector<int>>& triangle) {
    int n = triangle.size();
    vector<vector<int>> f(n, vector<int>(n));
    f[0][0] = triangle[0][0];
    if(n==1){
        return f[0][0];
    }
    for (int i = 1; i < n; i++){
        f[i][0] = f[i - 1][0] + triangle[i][0];
        for (int j = 0; j < i; j++){
            f[i][j] = min(f[i - 1][j - 1], f[i - 1][j]) + triangle[i][j];
        }
        f[i][i] = f[i - 1][i - 1] + triangle[i][i];
    }
    return *min_element(f[n-1].begin(),f[n-1].end());
}

int main(){
    int N;
    scanf("%d", &N);
    vector<vector<int> > obj(N); //定义二维动态数组大小5行 
    for(int i =0; i< obj.size(); i++)//动态二维数组为5行6列，值全为0 
    { 
        obj[i].resize(i+1); 
    } 
 
    for(int i=0; i< obj.size(); i++)//输出二维动态数组 
    {
        for(int j=0;j<obj[i].size();j++)
        {
            cin >> obj[i][j];
        }
    }
    int x=minimumTotal(obj);
    printf("%d", x);
    return 0;
}