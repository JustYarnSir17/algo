import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    static int[][] arr;
    static boolean[][] v;
    static int M;
    static int N;
    static int K;
    static Queue<pair> q= new LinkedList<>();
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    static int count=0;
    static int [] dr= {-1,1,0,0};
    static int [] dc= {0,0,1,-1};


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        arr = new int[m][n];
        v = new boolean[m][n];
        N=n;
        M=m;
        K=k;
        for(int i=0;i<k;i++){
            st = new StringTokenizer(br.readLine());
            int x1= Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2= Integer.parseInt(st.nextToken());
            int y2= Integer.parseInt(st.nextToken());
            fill(x1,y1,x2,y2);
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j]!=1&&v[i][j]!=true){
                    find(i,j);
                    ++count;
                }

            }
        }
        bw.write(count+"\n");
        while(!pq.isEmpty()){
            bw.write(pq.poll()+" ");
        }
        bw.close();
        br.close();



    }
    public static void fill(int x1,int y1,int x2,int y2){
        for(int i=x1;i<x2;i++){
            for(int j=y1;j<y2;j++){
                arr[j][i]=1;
            }
        }

    }
    public static void find(int x,int y){
        int cnt=1;
        q.add(new pair(x,y));
        v[x][y]=true;
        while(!q.isEmpty()){
            pair tmp = q.poll();
            for(int i=0;i<4;i++){
                int nr= tmp.r+dr[i];
                int nc=tmp.c+dc[i];
                if(nc>=N||nc<0||nr>=M||nr<0)
                    continue;
                if(arr[nr][nc]!=1&&v[nr][nc]!=true){
                    q.add(new pair(nr,nc));
                    v[nr][nc]=true;
                    ++cnt;
                }

            }
        }
        pq.add(cnt);
    }
}
class pair{
    int r;
    int c;
    pair(int r,int c){
        this.r=r;
        this.c=c;
    }
}