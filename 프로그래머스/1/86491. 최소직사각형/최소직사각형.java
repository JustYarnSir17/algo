import java.util.*;
import java.math.*;

class Solution {
    public int solution(int[][] sizes) {
        int w=0,h=0;
        for(int i=0;i<sizes.length;i++){
            if(sizes[i][0]>sizes[i][1]){
                w=Math.max(w,sizes[i][0]);
            h=Math.max(h,sizes[i][1]);}
            else{
                w=Math.max(w,sizes[i][1]);
            h=Math.max(h,sizes[i][0]);
            }
        }
        int answer = w*h;
        return answer;
    }
}