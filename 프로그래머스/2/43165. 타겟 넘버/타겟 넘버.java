import java.util.*;

class Solution {
    static int [] Numbers;
    static int sum=0;
    static int count=0;
    static int N;
    static int Target;
    
    static void dfs(int n){
        if(n==N){
            if(sum==Target){
                ++count;
            }
            return;
        }
        sum+=Numbers[n];
        dfs(n+1);
        sum-=Numbers[n];
        sum-=Numbers[n];
        dfs(n+1);
        sum+=Numbers[n];
    }
    
    public int solution(int[] numbers, int target) {
        N=numbers.length;
        Target= target;
        Numbers=numbers;
        dfs(0);
        
        int answer = count;
        return answer;
    }
}