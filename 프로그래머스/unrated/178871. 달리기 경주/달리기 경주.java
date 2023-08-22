import java.util.*;


class Solution {
    public String[] solution(String[] players, String[] callings) {
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        for(int i=0;i<players.length;i++){
            map.put(players[i],i);
        }
        for(int i=0;i<callings.length;i++){
            //불린 사람의 앞에 있는 사람 임시 저장
            String tmp = players[map.get(callings[i])-1];
            //추월
            swap(players,map.get(callings[i]));
            //등수 앞당기기
            map.replace(callings[i],map.get(callings[i])-1);
            //등수 밀어내기
            map.replace(tmp,map.get(callings[i])+1);
            
        }
       
        String[] answer = players;
        return answer;
    }
    void swap (String [] arr, int idx){
        String tmp = arr[idx-1];
        arr[idx-1]=arr[idx];
        arr[idx]=tmp;
    }
    
}

