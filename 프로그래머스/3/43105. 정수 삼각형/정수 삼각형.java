import java.util.*;
import java.math.*;
class Solution {
    public int solution(int[][] triangle) {
        int [][] dp;
        dp = new int [triangle.length][];
        for(int i=0;i<triangle.length;i++){
            dp[i]=new int [triangle[i].length];
        }
        dp[0][0]=triangle[0][0];
        for(int i=1;i<dp.length;i++){
            for(int j=0;j<=i;j++){
                if(j==0){
                    dp[i][j]=dp[i-1][j]+triangle[i][j];
                }
                else if(j==i){
                    dp[i][j]=dp[i-1][j-1]+triangle[i][j];
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j-1]+triangle[i][j],dp[i-1][j]+triangle[i][j]);
                }
            }
        }
        int answer = 0;
        for(int i=0;i<dp[dp.length-1].length;i++){
            answer=Math.max(dp[dp.length-1][i],answer);
        }
        return answer;
    }
}