import java.util.*;
import java.math.*;

class Solution {
    static int [][]DG;
    static int cnt=0;
    static int F;
    static int L;
    static boolean [] v;
    
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        L = dungeons.length;
        F=k;
        v= new boolean[L];
        DG= new int [L][2];
        for(int i=0;i<L;i++){
            DG[i][0]=dungeons[i][0];
            DG[i][1]=dungeons[i][1];
        }
        find(L,0);
        
        return cnt;
    }
    public void find(int l,int d){
        if(l==0){
            cnt = Math.max(cnt,d);
            return;
        }
        for(int i=0;i<L;i++){
            
            if(v[i])
                continue;
            if(F>=DG[i][0]){
                F-=DG[i][1];
                v[i]=true;
                find(l-1,d+1);
                v[i]=false;
                F+=DG[i][1];
            }
            else{
                v[i]=true;
            find(l-1,d);
            v[i]=false;
            }
            
        }
    }   
}