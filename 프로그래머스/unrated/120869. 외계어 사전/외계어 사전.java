import java.util.*;
class Solution {
    public int solution(String[] spell, String[] dic) {
        HashMap<Character,Boolean> map = new HashMap<>();
        int count=0;
        for(int i=0;i<spell.length;i++){
            map.put(spell[i].charAt(0),false);
            ++count;
        }
        int answer = 0;
        for(int i=0;i<dic.length;i++){
            HashMap<Character,Boolean> tmp = new HashMap<>(map);
            for(int j=0;j<dic[i].length();j++){
                
                if(tmp.containsKey(dic[i].charAt(j))){
                    tmp.replace(dic[i].charAt(j),true);
                    
                }
            }
            Iterator<Character> keys = tmp.keySet().iterator();
            while(keys.hasNext()){
                char key=keys.next();
                if(tmp.get(key)==false){
                    answer=2;
                    break;
                }
                else{
                    answer=1;
                }
            }
            if(answer==1){
                break;
            }
        }
        
        return answer;
    }
}