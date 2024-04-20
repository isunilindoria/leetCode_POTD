#include <iostream>
#include <bits/stdc++.h>
using namespace std;

void dfs(int row, int col, int &r1, int &c1, int &r2, int &c2, vector<vector<int>> &land)
{
    if (row >= land.size() || col >= land[row].size() || land[row][col] != 1)
        return;
    land[row][col] = 0;
    r1 = min(r1, row), c1 = min(c1, col), r2 = max(r2, row), c2 = max(c2, col);
    dfs(row + 1, col, r1, c1, r2, c2, land);
    dfs(row, col + 1, r1, c1, r2, c2, land);
}
vector<vector<int>> findFarmland(vector<vector<int>> &land)
{
    vector<vector<int>> ans;
    for (int i = 0; i < land.size(); i++)
        for (int j = 0; j < land[i].size(); j++)
        {
            if (land[i][j] == 1)
            {
                int r1 = i, c1 = j, r2 = i, c2 = j;
                dfs(i, j, r1, c1, r2, c2, land);
                ans.push_back({r1, c1, r2, c2});
            }
        }
    return ans;
}

int main()
{
    vector<vector<int>> land = {{1, 0, 0}, {0, 1, 1}, {0, 1, 1}};
    findFarmland(land);

    return 0;
}
