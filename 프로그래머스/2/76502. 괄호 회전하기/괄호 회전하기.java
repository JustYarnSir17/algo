import java.util.*;


class Solution {
    public int solution(String s) {
        ArrayList<Character> list = new ArrayList<>();
        int answer = 0;
        int length = s.length();
        Stack<Character> stack = new Stack<>();
        
        
        for(int i=0;i<length;i++){
            list.add(s.charAt(i));
        }
        while(length>0){
            boolean tr= false;
            loop:
            for(int i=0;i<list.size();i++){
                
                switch(list.get(i)){
                    case ')':
                        if(!stack.isEmpty()&&stack.peek()=='('){
                            stack.pop();
                        }
                        else{
                            tr=true;
                            break loop;
                        }
                        break;
                    case '}':
                        if(!stack.isEmpty()&&stack.peek()=='{'){
                            stack.pop();
                        }
                        else{
                            tr=true;
                            break loop;
                        }
                        break;
                    case ']':
                        if(!stack.isEmpty()&&stack.peek()=='['){
                            stack.pop();
                        }
                        else{
                            tr=true;
                            break loop;
                        }
                        break;
                    default:
                        stack.push(list.get(i));
                }
            }
            if(!tr&&stack.isEmpty()){
                ++answer;
            }
            char tmp =list.get(0);
            list.remove(0);
            list.add(tmp);
            --length;
        }
        return answer;
    }
}