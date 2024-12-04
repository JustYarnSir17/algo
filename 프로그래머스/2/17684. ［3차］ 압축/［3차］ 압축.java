import java.util.*;

class Solution {
    public int[] solution(String msg) {
        HashMap<String,Integer> map =new HashMap<>();
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for(int i=0;i<str.length();i++){
            map.put(str.substring(i,i+1),i+1);
        }
        List<Integer> list=  new ArrayList<>();
        
        for(int i=0;i<msg.length();i++){
            int j=i;
            int idx=0;
            boolean tr=false;
            while(j<msg.length()){
                if(map.containsKey(msg.substring(i,j+1))){
                    idx=map.get(msg.substring(i,j+1));
                    j++;
                }
                else{
                    tr=true;
                    break;
                }
            }
            if(tr){//해당하는 문자가 존재하지 않을 때
                map.put(msg.substring(i,j+1),map.size()+1);//넣기
                list.add(idx);//존재했던 인덱스 넣기
            }
            else{//문자가 존재했고 j가 문자열 끝까지 돌았을 때
                list.add(idx);
                break;
            }
            i=j-1;
        }
        int[] answer = new int[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i]=list.get(i);
        }
        return answer;
    }
}