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
        
        for (int j = 0; j < i; j++){

        }
    }
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
    minimumTotal(obj);
    return 0;
}