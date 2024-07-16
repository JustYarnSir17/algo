#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
#include  <climits>
using namespace std;

const int dr[] = { 1,-1,0,0 };
const int dc[] = { 0,0,1,-1 };

void dijkstra(vector<vector<int>>& grid, int x, int y) {
    int n = grid.size();
    int m = grid[0].size();

    vector<vector<int>> dist(n, vector<int>(m,INT_MAX));
    dist[x][y] = grid[x][y];

    priority_queue<pair<int, pair<int, int>>, vector<pair<int, pair<int, int>>>, greater<pair<int, pair<int, int>>>>  pq;
    pq.push({ {grid[x][y]}, {x, y} });

    while (!pq.empty()) {
        auto [currentCost, pos] = pq.top();
        pq.pop();
        int r = pos.first;
        int c = pos.second;

        if (currentCost > dist[r][c])continue;

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
                continue;
            }
            int nCost = currentCost + grid[nr][nc];
            if (nCost < dist[nr][nc]) {
                dist[nr][nc] = nCost;
                pq.push({ nCost,{nr,nc} });
            }
        }

    }
    cout << dist[n-1][m-1];

}

int main() {
    int n;
    int m;
    cin >> m >> n;

    // 초기화
    vector<vector<int>> arr(n, vector<int>(m));
    
    for (int i = 0; i < n; i++) {
        string row;
        cin >> row;
        for (int j = 0; j < m; j++) {
            arr[i][j]=row[j]-'0';
        }
    }
    dijkstra(arr, 0, 0);

    return 0;
}