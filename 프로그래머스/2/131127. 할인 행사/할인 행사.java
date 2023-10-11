import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int count=0;
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i=0;i<want.length;i++){
            map.put(want[i],number[i]);
            count+=number[i];
        }

        int day =0;
        int dd= discount.length;
        
        loop:
        while(true){
            HashMap<String,Integer> tmp = (HashMap<String,Integer>)map.clone();
            int num = count;
            for(int i=day;i<day+10;i++){
                if(i>=dd)
                    break loop;
                if(tmp.containsKey(discount[i])){
                    if(tmp.get(discount[i])>0){
                        tmp.replace(discount[i],tmp.get(discount[i])-1);
                        num--;
                    }
                }
            }
            if(num<=0){
                answer++;
            }
            day++;
        }
        
        
        return answer;
    }
}