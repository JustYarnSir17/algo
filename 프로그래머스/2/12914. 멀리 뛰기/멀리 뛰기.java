import java.util.*;
class Solution {
    static int N;
    static int count =0;
    static int [] dist = new int [2001];
    public void find(){
        dist[1]=1;
        dist[2]=2;
        for(int i=3;i<=2000;i++){
            dist[i]=(dist[i-2]+dist[i-1])%1234567;
        }
    }
    public long solution(int n) {
        //1칸 또는 2칸 뛸 수 있다.
        find();
        
        long answer = dist[n];
        return answer;
    }
}