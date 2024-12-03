import java.util.*;

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        
        StringTokenizer st = new StringTokenizer(video_len,":");
        int len = Integer.parseInt(st.nextToken())*60;
        len+=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(pos,":");
        int curr= Integer.parseInt(st.nextToken())*60;
        curr+=Integer.parseInt(st.nextToken());
        st = new StringTokenizer(op_start,":");
        int start = Integer.parseInt(st.nextToken())*60;
        start += Integer.parseInt(st.nextToken());
        st= new StringTokenizer(op_end,":");
        int end = Integer.parseInt(st.nextToken())*60;
        end += Integer.parseInt(st.nextToken());
        if(start<=curr&&curr<=end){
            curr=end;
        }
        
        for(int i=0;i<commands.length;i++){
            if(commands[i].equals("next")){
                curr+=10;
                if(curr>len){
                    curr=len;
                }
            }
            else{
                curr-=10;
                if(curr<0){
                    curr=0;
                }
            }
            if(start<=curr&&curr<=end){
            curr=end;
        }
        }
        if(start<=curr&&curr<=end){
            curr=end;
        }
        
        int m=curr/60;
        int s=curr%60;
        StringBuilder sb= new StringBuilder();
        if(m<10){
            sb.append("0"+m+":");
        }
        else{
            sb.append(m+":");
        }
        if(s<10){
            sb.append("0"+s);
        }   
        else{
            sb.append(s);
        }
        
        String answer = sb.toString();
        return answer;
    }
}