import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        List<String> list = new ArrayList<>();
        
        if(cacheSize>0){
            for(int i=0;i<cities.length;i++){
                boolean tr= false;
                String city = cities[i].toUpperCase();
                for(int j=0;j<list.size();j++){
                    if(list.get(j).equals(city)){
                        list.remove(j);
                        list.add(city);
                        answer+=1;
                        tr=true;
                        break;
                    }
                }
                if(!tr){
                    if(list.size()>=cacheSize){
                        list.remove(0);
                    }
                    list.add(city);
                    answer+=5;
                }
            }
        }
        else{
            answer=5*cities.length;   
        }
        return answer;
        
    }
}