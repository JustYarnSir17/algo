import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = 0;
        
        while(true){
            if(n%2==0){
                n=n/2;
                
            }
            else{
                ++ans;
                --n;
            }
            if(n==0)
                break;
        }
            

        return ans;
    }
}