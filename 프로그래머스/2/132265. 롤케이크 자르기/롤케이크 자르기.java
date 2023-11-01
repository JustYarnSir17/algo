import java.util.*;
class Solution {
    public int solution(int[] topping) {
        int answer=0;
        HashMap<Integer,Integer> map =new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        int size= topping.length;
        for(int i=0;i<size;i++){
            if(!map.containsKey(topping[i])){
                map.put(topping[i],1);
            }
            else{
                map.put(topping[i],map.get(topping[i])+1);
            }
        }
        for(int i=0;i<size;i++){
            set.add(topping[i]);
            if(map.get(topping[i])==1){
                map.remove(topping[i]);
            }
            else{
                map.put(topping[i],map.get(topping[i])-1);
            }
            if(map.size()==set.size()){
                answer++;
            }
        }
        return answer;
    }
}