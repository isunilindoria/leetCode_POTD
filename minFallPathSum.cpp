#include <iostream>
#include <bits/stdc++.h>
using namespace std;

int minFallingPathSum(vector<vector<int>> &grid)
{
    int n = grid.size();
    if (n == 1)
        return grid[0][0];

    // Create a dp array which will store the minimum sum up to row i
    vector<vector<int>> dp(n, vector<int>(n, INT_MAX));

    // Initialize the first row of dp with the first row of grid
    for (int j = 0; j < n; ++j)
    {
        dp[0][j] = grid[0][j];
    }

    // Fill the dp array
    for (int i = 1; i < n; ++i)
    {
        for (int j = 0; j < n; ++j)
        {
            // Find the minimum value in the previous row, excluding the current column
            int minVal = INT_MAX;
            for (int k = 0; k < n; ++k)
            {
                if (k != j)
                {
                    minVal = min(minVal, dp[i - 1][k]);
                }
            }
            // Update dp[i][j] with the minimum found plus current grid value
            dp[i][j] = grid[i][j] + minVal;
        }
    }

    // Find the minimum value in the last row of dp
    int result = INT_MAX;
    for (int j = 0; j < n; ++j)
    {
        result = min(result, dp[n - 1][j]);
    }

    return result;
}

int main()
{
    vector<vector<int>> matrix = {{-73, 61, 43, -48, -36},
                                  {3, 30, 27, 57, 10},
                                  {96, -76, 84, 59, -15},
                                  {5, -49, 76, 31, -7},
                                  {97, 91, 61, -46, 67}};

    cout << minFallingPathSum(matrix);

    return 0;
}