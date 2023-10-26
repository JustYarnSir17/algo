import java.util.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int [] answer=new int [2];
        Node start= new Node(0,0);
        find:
        for(int i=0;i<park.length;i++){
            for(int j=0;j<park[0].length();j++){
                if(park[i].charAt(j)=='S'){
                    start = new Node(i,j);
                    break find;
                }
            }
        }
        for(int i=0;i<routes.length;i++){
            StringTokenizer st = new StringTokenizer(routes[i]);
            char dir= st.nextToken().charAt(0);
            Integer dist = Integer.parseInt(st.nextToken());
            if(dir=='S'){
                int idx=1;
                while(true){
                if(start.r+idx<park.length&&park[start.r+idx].charAt(start.c)!='X'){
                    if(idx==dist){
                        start.r=start.r+idx;
                        break;
                    }
                    ++idx;
                }
                else{
                    break;
                }
                    
                }
            }
            else if(dir=='N'){
                int idx=1;
                while(true){
                if(start.r-idx>=0&&park[start.r-idx].charAt(start.c)!='X'){
                    if(idx==dist){
                        start.r=start.r-idx;
                        break;
                    }
                    ++idx;
                }
                else{
                    break;
                }
                    
                }
                
            }
            else if(dir=='E'){
                int idx=1;
                while(true){
                if(start.c+idx<park[0].length()&&park[start.r].charAt(start.c+idx)!='X'){
                    if(idx==dist){
                        start.c=start.c+idx;
                        break;
                    }
                    ++idx;
                }
                else{
                    break;
                }
                    
                }
            }
            else{
                int idx=1;
                while(true){
                if(start.c-idx>=0&&park[start.r].charAt(start.c-idx)!='X'){
                    if(idx==dist){
                        start.c=start.c-idx;
                        break;
                    }
                    ++idx;
                }
                else{
                    break;
                }
                    
                }
            }
            
        }
        
        answer[0]=start.r;
        answer[1]=start.c;
        return answer;
    }
    class Node {
        int r;
        int c;
        Node(int r, int c){
            this.r =r;
            this.c =c;
        }
    }
    
}

 