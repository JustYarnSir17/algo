import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        Stack<Pair> stack = new Stack<>();
        
        
        
        int[] answer = new int[numbers.length];
        
        for(int i=0;i<numbers.length;i++){
            if(stack.isEmpty()){
                stack.push(new Pair(i,numbers[i]));
                
            }
            else{
                while(stack.peek().val<numbers[i]){
                    Pair tmp = stack.pop();
                    answer[tmp.num]=numbers[i];
                    if(stack.isEmpty()){
                        break;
                    }
                }
                stack.push(new Pair(i,numbers[i]));
            }
        }
        while(!stack.isEmpty()){
            Pair tmp = stack.pop();
            answer[tmp.num]=-1;
        }
        
        return answer;
    }
    
}

class Pair{
    int num;
    int val;
    Pair(int num,int val){
        this.num=num;
        this.val=val;
    }
}