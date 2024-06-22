import java.util.*;
import java.math.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {0,0};
        for(int height=1;height<=Math.sqrt(yellow);height++){
            if(yellow%height==0){
                int width= yellow/height;
                if(2*(width+height)+4==brown){
                    answer[0]=width+2;
                    answer[1]=height+2;
                }
            }
            
        }
        
        
        
        return answer;
    }
}