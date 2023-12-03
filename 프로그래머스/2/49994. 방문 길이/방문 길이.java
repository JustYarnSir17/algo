import java.util.*;
class Solution {
    public int solution(String dirs) {
        HashSet<String> set = new HashSet<>();
        
        Node start = new Node(0,0);
        for(int i=0;i<dirs.length();i++){
            char com = dirs.charAt(i);
            String tmp1 = "";
            String tmp2 = "";
            
            switch(com){
                case 'U':
                    if(start.r+1<=5){
                        tmp1+=start.r;
                        tmp1+=start.c;
                        tmp1+="to";
                        tmp1+=start.r+1;
                        tmp1+=start.c;
                        tmp2+=start.r+1;
                        tmp2+=start.c;
                        tmp2+="to";
                        tmp2+=start.r;
                        tmp2+=start.c;
                        ++start.r;
                        }
                    else
                        continue;
                    
                    break;
                case 'D':
                    if(start.r-1>=-5){
                        tmp1+=start.r;
                        tmp1+=start.c;
                        tmp1+="to";
                        tmp1+=start.r-1;
                        tmp1+=start.c;
                        tmp2+=start.r-1;
                        tmp2+=start.c;
                        tmp2+="to";
                        tmp2+=start.r;
                        tmp2+=start.c;
                        --start.r;
                        }
                      else
                        continue;
                    
                    
                    break;
                case 'R':
                    if(start.c+1<=5){
                        tmp1+=start.r;
                        tmp1+=start.c;
                        tmp1+="to";
                        tmp1+=start.r;
                        tmp1+=start.c+1;
                        tmp2+=start.r;
                        tmp2+=start.c+1;
                        tmp2+="to";
                        tmp2+=start.r;
                        tmp2+=start.c;
                        ++start.c;
                    }
                      else
                        continue;
                    
                    break;
                case 'L':
                    if(start.c-1>=-5){
                        tmp1+=start.r;
                        tmp1+=start.c;
                        tmp1+="to";
                        tmp1+=start.r;
                        tmp1+=start.c-1;
                        tmp2+=start.r;
                        tmp2+=start.c-1;
                        tmp2+="to";
                        tmp2+=start.r;
                        tmp2+=start.c;
                        --start.c;
                    }
                      else
                        continue;
                    
                    break;
                    
                    
            }
            set.add(tmp1);
            set.add(tmp2);
        }
        int answer = set.size()/2;
        return answer;
    }
}
class Node{
    int r;
    int c;
    Node(int r, int c){
        this.r= r;
        this.c=c;
    }
}