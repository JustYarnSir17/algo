import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        Queue<Node> q = new LinkedList<>();
        Stack<Integer> stack= new Stack<>();
        for(int i=0;i<priorities.length;i++){
            q.offer(new Node(priorities[i],i));
        }
        Arrays.sort(priorities);
        for(int i=0;i<priorities.length;i++){
            stack.push(priorities[i]);
            
        }
        while(!q.isEmpty()){
            if(q.peek().p==stack.peek()){
                Node tmp = q.poll();
                stack.pop();
                ++answer;
                if(location==tmp.l)
                    break;
            }
            else{
                Node tmp = q.poll();
                q.offer(tmp);
                
            }
        }
        
        return answer;
    }
}
class Node{
    int p;
    int l;
    Node(int p, int l){
        this.p=p;
        this.l=l;
    }
}