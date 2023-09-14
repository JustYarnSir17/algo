import java.util.*;
class Solution {
    public String solution(String s) {
        s =s.toLowerCase();
        for(int i=0;i<s.length();i++){
            if(i==0){
                if(s.charAt(0)>='a'&&s.charAt(0)<='z'){
                    s=s.substring(0,1).toUpperCase()+s.substring(1);
                }
            }
            else{
                if(s.charAt(i-1)==' ' &&s.charAt(i)>='a'&&s.charAt(i)<='z'){
                    s=s.substring(0,i)+s.substring(i,i+1).toUpperCase()+s.substring(i+1);
                }
            }
        }
        String answer = s;
        return answer;
    }
}