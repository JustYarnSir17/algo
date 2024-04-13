import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0,0};
        HashSet<String> set = new HashSet<>();
        int cnt=1;
        int cycle=1;
        boolean tr= false;
        String peek=words[0];
        set.add(words[0]);
        for(int i=1;i<words.length;i++){
            ++cnt;
            if(cnt>n){
                ++cycle;
                cnt=1;
            }
            if(words[i].charAt(0)==peek.charAt(peek.length()-1)){
                if(set.contains(words[i])){
                tr=true;
                break;
            }
            else{
                peek=words[i];
                set.add(words[i]);
            }
            }
            else{
                tr=true;
                break;
            }
            
        }
        if(tr){
        answer[0]=cnt;
        answer[1]=cycle;
        }
        System.out.println("Hello Java");

        return answer;
    }
}