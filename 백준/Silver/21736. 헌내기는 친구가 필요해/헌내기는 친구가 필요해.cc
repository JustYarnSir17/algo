#include <iostream>
#include <queue>
using namespace std;

const int dr[4] = {1,0,-1,0};
const int dc[4] = { 0,1,0,-1 };
int n, m;
char** arr;
bool** v;

struct Node{
    int r;
    int c;
    Node(int r, int c) {
        this->r = r;
        this->c = c;
    }
    Node() {
        this->r = 0;
        this->c = 0;
    }

} ;

int find(Node start) {
    int cnt=0;
    queue<Node> q;
    q.push(start);
    v[start.r][start.c] = true;
    while (!q.empty()) {
        Node curr = q.front();
        q.pop();
        for (int i = 0; i < 4; i++) {
            int nr = curr.r + dr[i];
            int nc = curr.c + dc[i];
            if (nr < 0 || nr >= n || nc < 0 || nc >= m)
                continue;
            if (arr[nr][nc] == 'O' && !v[nr][nc]) {
                v[nr][nc] = true;
                q.push(Node(nr, nc));
            }
            else if (arr[nr][nc] == 'P' && !v[nr][nc]) {
                v[nr][nc] = true;
                cnt++;
                q.push(Node(nr, nc));
            }
        }
            
    }


    return cnt;
}

int main() {
    cin >> n >> m;
    arr = new char* [n];
    v = new bool* [n];
    Node start;
    for (int i = 0; i < n; i++) {
        arr[i] = new char[m];
        v[i] = new bool[m];
    }

    for (int i = 0; i < n; i++) {
        string str;
        cin >> str;
        for (int j = 0; j < m; j++) {
            arr[i][j] = str.at(j);
            if (arr[i][j] == 'I') {
                start = Node(i, j);
            }
            v[i][j] = false;
        }
    }

    int count = find(start);

    if(count>0){
    cout << count << endl;
    }
    else {
        cout << "TT" << endl;
    }

    return 0;
}