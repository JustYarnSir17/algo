import java.util.*;
class Solution {
    public int solution(int n) {
        int front=0;
        int rear=0;
        int sum=0;
        int cnt=0;
        while(front<=n&&rear<=n){
            if(sum<n){
                ++rear;
                sum+=rear;
            }
            else if(sum>n){
                sum-=front;
                ++front;
            }
            else{
                ++cnt;
                ++rear;
                sum+=rear;
                sum-=front;
                ++front;
            }
        }
        int answer = cnt;
        return answer;
    }
}