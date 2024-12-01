import java.util.*;

class Solution {
    public int[] solution(String s) {
        HashSet<Integer> set = new HashSet<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        PriorityQueue<int[]>pq = new PriorityQueue<int[]>(new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[]o2){
                return o2[1]-o1[1];
            }
        });
        StringTokenizer st= new StringTokenizer(s,"{},");
        while(st.hasMoreTokens()){
            int tmp = Integer.parseInt(st.nextToken());
            if(set.contains(tmp)){
                map.replace(tmp,map.get(tmp)+1);
            }
            else{
                set.add(tmp);
                map.put(tmp,1);
            }
        }
        for(int num:set){
            int cnt= map.get(num);
            pq.offer(new int[]{num,cnt});
        }
        int[] answer = new int [pq.size()];
        int idx=0;
        while(!pq.isEmpty()){
            answer[idx++]=pq.poll()[0];
        }
        return answer;
    }
}