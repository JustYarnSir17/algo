import java.util.*;
class Solution {
    static int [] dr = {1,0,-1,0};
    static int [] dc = {0,-1,0,1};
    static int count=0;
    static boolean [][] v;
    static boolean [][] v2;
    static Node start;
    static Queue<Node> q = new LinkedList<>();
    static Queue<Node> q2 = new LinkedList<>();
    static int N;
    static int M;
    static String[] map;
    static int end=-1;
    public int solution(String[] maps) {
        int answer = 0;
        map=maps;
        N=maps.length;
        M=maps[0].length();
        v=new boolean[maps.length][maps[0].length()];
        v2=new boolean[maps.length][maps[0].length()];
        for(int i=0;i<maps.length;i++){
            for(int j=0;j<maps[i].length();j++){
                if(maps[i].charAt(j)=='S'){
                    start= new Node(i,j,0);
                    v[i][j]=true;
                }
            }
        }
        
        q.offer(start);
        find();
        exit();
        answer=end;
        return answer;
    }
    public void find(){
        while(!q.isEmpty()){
            Node tmp = q.poll();
            if(map[tmp.r].charAt(tmp.c)=='L'){
                q2.offer(tmp);
                break;
            }
            for(int i=0;i<4;i++){
                int nr = tmp.r+dr[i];
                int nc = tmp.c+dc[i];
                if(nr>=0&&nr<N&&nc>=0&&nc<M){
                    if(!v[nr][nc]&&map[nr].charAt(nc)!='X'){
                        q.offer(new Node(nr,nc,tmp.cnt+1));
                        v[nr][nc]=true;
                    }
                }
            }
        }
    }
    public void exit(){
        while(!q2.isEmpty()){
            Node tmp = q2.poll();
            if(map[tmp.r].charAt(tmp.c)=='E'){
                end= tmp.cnt;
                break;
            }
            for(int i=0;i<4;i++){
                int nr = tmp.r+dr[i];
                int nc = tmp.c+dc[i];
                if(nr>=0&&nr<N&&nc>=0&&nc<M){
                    if(!v2[nr][nc]&&map[nr].charAt(nc)!='X'){
                        q2.offer(new Node(nr,nc,tmp.cnt+1));
                        v2[nr][nc]=true;
                    }
                }
            }
        }
    }
}
class Node{
    int r;
    int c;
    int cnt;
    Node(int r, int c,int cnt){
        this.r=r;
        this.c=c;
        this.cnt=cnt;
    }
}