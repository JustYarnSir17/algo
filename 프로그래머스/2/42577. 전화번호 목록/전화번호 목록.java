import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        HashMap<String,Integer> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        for(int i=0;i<phone_book.length;i++){
            set.add(phone_book[i]);
            map.put(phone_book[i],0);
        }
        for(int i=0;i<phone_book.length;i++){
            for(int j=1;j<=phone_book[i].length();j++){
                String tmp = phone_book[i].substring(0,j);
                if(set.contains(tmp)&&map.containsKey(tmp)){
                    map.replace(tmp,map.get(tmp)+1);
                    if(map.get(tmp)>1){
                        answer=false;
                    }
                    
                }
            }
        }
        
        return answer;
    }
}