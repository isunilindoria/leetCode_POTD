#include <iostream>
#include <bits/stdc++.h>
using namespace std;

void helper(int row, int col, vector<vector<char>> &grid)
{
    if (row < 0 || row >= grid.size() || col < 0 || col >= grid[row].size() || grid[row][col] == '0')
        return;

    grid[row][col] = '0';
    helper(row - 1, col, grid);
    helper(row + 1, col, grid);
    helper(row, col - 1, grid);
    helper(row, col + 1, grid);
}

int numIslands(vector<vector<char>> &grid)
{
    int noIsland = 0;
    for (int i = 0; i < grid.size(); i++)
    {
        for (int j = 0; j < grid[i].size(); j++)
        {
            if (grid[i][j] == '1')
            {
                noIsland++;
                helper(i, j, grid);
            }
        }
    }
    return noIsland;
}

int main()
{
    // #ifndef ONLINE JUDGE
    //     freopen("input.txt", "r", stdin);
    //     freopen("output.txt", "w", stdout);
    // #endif

    vector<vector<char>> v = {
        {'1', '1', '1', '1', '0'},
        {'1', '1', '0', '1', '0'},
        {'1', '1', '0', '0', '0'},
        {'0', '0', '0', '0', '0'}};
    cout << numIslands(v);

    return 0;
}