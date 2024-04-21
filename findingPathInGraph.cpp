#include <iostream>
#include <bits/stdc++.h>
using namespace std;

bool helper(unordered_map<int, vector<int>> graph, unordered_set<int> &vis, int source, int destination)
{
    if(source == destination) return true;
    vis.insert(source);

    for(auto it : graph[source])
    {
        if(vis.find(it) == vis.end())
        {
            if(helper(graph, vis, it, destination)) return true;
        }
    }
    return false;
}

bool validPath(int n, vector<vector<int>> &edges, int source, int destination)
{
    unordered_map<int, vector<int>> graph;
    for(auto it : edges)
    {
        int u = it[0];
        int v = it[1];
        graph[u].push_back(v);
        graph[v].push_back(u);
    }
    unordered_set<int> vis; 
    return helper(graph, vis, source, destination);
}
int main()
{
    vector<vector<int>> edges = {{0, 1}, {1, 2}, {2, 0}};
    cout << validPath(3, edges, 0, 2);
    return 0;
}