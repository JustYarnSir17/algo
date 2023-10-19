import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        List<Integer> list= new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            if(i!=arr.length-1){
                if(arr[i]==arr[i+1]){
                    continue;
                }
                else{
                    list.add(arr[i]);
                }
                }
            else{
                list.add(arr[i]);
            }
        }
        
        answer = new int[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i]=list.get(i);
        }
        return answer;
    }
}