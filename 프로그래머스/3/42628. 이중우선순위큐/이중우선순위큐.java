import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        TreeMap<Integer,Integer> treeMap =new TreeMap<>();
        int idx=0;
        for(int i=0;i<operations.length;i++){
            StringTokenizer st = new StringTokenizer(operations[i]);
            String com = st.nextToken();
            if(com.equals("I")){
                int val =Integer.parseInt(st.nextToken());
                treeMap.put(val,idx++);
            }
            else{
                int val = Integer.parseInt(st.nextToken());
                if(val==1){
                    if(!treeMap.isEmpty()){
                        treeMap.pollLastEntry();
                    }
                }
                else{
                    if(!treeMap.isEmpty()){
                        treeMap.pollFirstEntry();
                    }
                }
            }
        }
        
        if(treeMap.isEmpty()){
            return new int[]{0,0};
        }
        else{
            int [] answer= new int[2];
            answer[0]=treeMap.lastKey();
            answer[1]=treeMap.firstKey();
            return answer;
        }
    }
}