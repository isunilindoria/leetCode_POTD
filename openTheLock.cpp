# include<iostream>
# include <bits/stdc++.h>
using namespace std;

int findingTurns(vector<string> deadEnds, string target)
{
    unordered_set<string> dead(deadEnds.begin(), deadEnds.end());
    unordered_set<string> vis;
    queue<pair<string, int>> q;

    string start = "0000";
    if(dead.find(start) != dead.end()) return -1;
    q.push({start, 0});
    vis.insert(start);

    while(!q.empty())
    {
        // auto state, turns = q.front();
        string state = q.front().first;
        int turns = q.front().second;
        q.pop();

        if(state == target) return turns;

        for(int i = 0; i < 4; i++)
        {
            string s1 = state;
            string s2 = state;
            s1[i] = (state[i] - '0' + 1) % 10 + '0';
            s2[i] = (state[i] - '0' - 1 + 10) % 10 + '0';

            if(vis.find(s1) == vis.end() && dead.find(s1) == dead.end())
            {
                vis.insert(s1);
                q.push({s1, turns + 1});
            }
            if(vis.find(s2) == vis.end() && dead.find(s2) == dead.end())
            {
                vis.insert(s2);            
                q.push({s2, turns + 1});
            }            
            
        }
    }
    return -1;
}


int main(){
    vector<string> deadEnds = {"0201","0101","0102","1212","2002"};
    cout<<findingTurns(deadEnds, "0202");    

    return 0;
}