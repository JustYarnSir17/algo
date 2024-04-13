import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    static char [][][] buil;
    static boolean[][][] v;
    static int []dr = {1,-1,0,0,0,0};
    static int []dc = {0,0,1,-1,0,0};
    static int []dl = {0,0,0,0,1,-1};

    static int L;
    static int R;
    static int C;
    static Loc start;
    static Loc end;

    static public void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L= Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        while(true){
            if(L==0 && R==0 && C==0){
                break;
            }
            buil= new char[L][R][C];
            v= new boolean[L][R][C];
            for(int i=0;i<L;i++){
                for(int j=0;j<R;j++){
                    String str = br.readLine();
                    for(int k=0;k<str.length();k++){
                        buil[i][j][k]=str.charAt(k);
                        if(str.charAt(k)=='S'){
                            start= new Loc(i,j,k,0);
                        }
                        if(str.charAt(k)=='E'){
                            end= new Loc(i,j,k,0);
                        }

                    }
                }
                br.readLine();
            }
            find(start);
            if(end.time!=0){
                bw.write("Escaped in "+end.time+" minute(s).\n");
            }
            else{
                bw.write("Trapped!\n");
            }
            st = new StringTokenizer(br.readLine());
            L= Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
        }
        bw.close();
        br.close();

    }
    static public void find(Loc start){
        Queue<Loc> q= new LinkedList<>();
        q.add(start);
        while(!q.isEmpty()){
            Loc tmp = q.poll();
            if(tmp.l==end.l&&tmp.r==end.r&&tmp.c==end.c){
                end=tmp;
                return;
            }
            for(int i=0;i<6;i++){
                int nr = tmp.r+dr[i];
                int nc = tmp.c+dc[i];
                int nl = tmp.l+dl[i];
                if(nr<0||nc<0||nl<0||nr>=R||nc>=C||nl>=L)
                    continue;
                if(buil[nl][nr][nc]!='#'&&v[nl][nr][nc]==false){
                    q.add(new Loc(nl,nr,nc,tmp.time+1));
                    v[nl][nr][nc]=true;
                }
            }
        }
    }
}
class Loc{
    int l;
    int r;
    int c;
    int time;
    Loc(int l,int r,int c,int time){
        this.l=l;
        this.r=r;
        this.c=c;
        this.time=time;
    }
}