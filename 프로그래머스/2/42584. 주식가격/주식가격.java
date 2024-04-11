import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int [prices.length];
        Stack<stock> stack = new Stack<>();
        
        for(int i=0;i<prices.length;i++){
            if(stack.isEmpty()){
                stack.add(new stock(prices[i],i));
            }
            else{
                if(prices[i]>=stack.peek().price){
                   stack.add(new stock(prices[i],i));
                }
                else{
                    while(stack.peek().price>prices[i]){
                    stock tmp = stack.pop();
                    answer[tmp.time]=i-tmp.time;
                        if(stack.isEmpty()){
                            break;
                        }
                    }
                    stack.add(new stock(prices[i],i));
                }
            }
        }
        while(!stack.isEmpty()){
            stock tmp = stack.pop();
            answer[tmp.time]=prices.length-tmp.time-1;
        }
        return answer;
    }
}
class stock{
    int price;
    int time;
    stock(int price,int time){
        this.price=price;
        this.time=time;
    }
}