import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int count =0;
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>(){
            @Override
            public int compare(Node o1, Node o2){
                return o1.end-o2.end;
            }
        });
        Node[] arr =new Node[targets.length];
        for(int i=0;i<targets.length;i++){
            arr[i]=new Node(targets[i][0],targets[i][1]);
        }
        Arrays.sort(arr,new Comparator<Node>(){
            @Override
            public int compare(Node o1, Node o2){
                return o1.start-o2.start;
            }
        });
        for(int i=0;i<arr.length;i++){
            if(pq.isEmpty()){
                pq.offer(arr[i]);
            }
            else{
                if(pq.peek().end<=arr[i].start){
                    pq.clear();
                    pq.offer(arr[i]);
                    count++;
                }
                else{
                    pq.offer(arr[i]);
                }
            }
        }
        if(!pq.isEmpty()){
            count++;
        }
        int answer=count;
        
        return answer;
    }
}
class Node{
    int start;
    int end;
    Node(int start,int end){
        this.start=start;
        this.end=end;
    }
}