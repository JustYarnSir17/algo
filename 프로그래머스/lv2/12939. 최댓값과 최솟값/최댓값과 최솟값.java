import java.util.*;
class Solution {
    public String solution(String s) {
        StringTokenizer st = new StringTokenizer(s);
        int min= Integer.parseInt(st.nextToken());
        int max= min;
        while(st.hasMoreTokens()){
            int tmp = Integer.parseInt(st.nextToken());
            if(min>tmp){
                min=tmp;
            }
            if(max<tmp){
                max=tmp;
            }
            
        }
        StringBuilder sb = new StringBuilder();
        sb.append(min).append(" ").append(max);
        String answer = sb.toString();
        return answer;
    }
}