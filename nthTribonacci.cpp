#include <iostream>
#include <bits/stdc++.h>
using namespace std;


// //-------- this can give TLE----------//
// int finding(int n)
// {
//     if (n == 0)
//         return 0;
//     if (n == 1 || n == 2) return 1;
//     return finding(n - 1) + finding(n - 2) + finding(n - 3);
// }


int finding(int n, unordered_map<int, int> &mpp)
{
    if(mpp.find(n) != mpp.end()) return mpp[n];
    int result;

    if(n == 0) result = 0;
    else if(n == 1 || n== 2) result = 1;
    else result = finding(n - 1, mpp) 
                  + finding( n - 2, mpp) 
                  + finding(n -3, mpp);
    mpp[n] = result;
    return result;
}

int main()
{
    unordered_map<int, int> mpp;
    cout << finding(25, mpp);

    return 0;
}