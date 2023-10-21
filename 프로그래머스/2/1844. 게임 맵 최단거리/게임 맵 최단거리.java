import java.util.*;
import java.math.*;

class Solution {
    static int [] dr = {1,0,0,-1};
    static int [] dc = {0,1,-1,0};
    static Queue<Node> q= new LinkedList<>();
    static int [][] Maps;
    static boolean [][] v;
    static int count=0;
    static int R,C;
    public void bfs(int r, int c){
        q.offer(new Node(r,c,1));
        v[r][c]=true;
        while(!q.isEmpty()){
            Node tmp = q.poll();
            for(int i=0;i<4;i++){
                int nr = tmp.r +dr[i];
                int nc = tmp.c +dc[i];
                if(nr>=0&&nr<R&&nc>=0&&nc<C){
                    if(nr==R-1&&nc==C-1){
                        count=tmp.num+1;
                        return;
                    }
                    if(!v[nr][nc]&&Maps[nr][nc]==1){
                        v[nr][nc]=true;
                        q.offer(new Node(nr,nc,tmp.num+1));
                    }
                }
            }
        }
    }
    public int solution(int[][] maps) {
        Maps=maps;
        R= maps.length;
        C= maps[0].length;
        v= new boolean[R][C];
        bfs(0,0);
        int answer = count;
        if(answer==0)
            answer=-1;
        
        return answer;
    }
}
class Node {
    int r ;
    int c;
    int num;
    Node(int r, int c,int num){
        this.r=r;
        this.c=c;
        this.num=num;
    }
}