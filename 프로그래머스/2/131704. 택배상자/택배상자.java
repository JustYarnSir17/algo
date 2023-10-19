import java.util.*;
class Solution {
    public int solution(int[] order) {
        //Stack,Queue 사용해서 풀이
        Queue<Integer> main = new LinkedList<>(); //주 벨트
        Stack<Integer> sub = new Stack<>(); //보조 벨트
        Queue<Integer> ord = new LinkedList<>(); //순서 
        for(int i=0;i<order.length;i++){
            main.offer(i+1);
            ord.offer(order[i]);
            }
        
        int answer=0;
        loop:
        while(!ord.isEmpty()){
            
            if(!main.isEmpty()){//메인 큐에 짐이 있을 때
                if(main.peek().intValue()==ord.peek().intValue()){//메인 큐 순서가 일치
                    main.poll();
                    ord.poll();
                    ++answer;
                    }
                else {//불일치
                   if(!sub.isEmpty()){//보조 짐 존재
                       if(sub.peek().intValue()==ord.peek().intValue()){//일치
                           sub.pop();
                           ord.poll();
                           ++answer;
                           }
                      else{//불일치
                          if(main.peek().intValue()>=ord.peek().intValue()){
                              //메인 짐이 순서보다 높을 때 결국 못 실음
                              break loop;
                              }
                         else{//메인 짐이 순서보다 낮을 때 서브로 빼기
                             sub.push(main.poll());
                         }
                      }
                       
                   }
                   else{//보조 짐 X
                       if(main.peek().intValue()>=ord.peek().intValue()){
                           break loop;
                       }
                       else
                        sub.push(main.poll());
                   }
                    
                }
                
            }
            else{//메인 큐에 짐이 없을 때
                if(!sub.isEmpty()){//보조 짐 존재
                    if(ord.peek().intValue()==sub.peek().intValue()){
                        ord.poll();
                        sub.pop();
                        ++answer;
                    }
                    else{
                        break;
                    }
                    }
               else{
                   break;
               }
            }
            
        }
    
        return answer;
    }
}