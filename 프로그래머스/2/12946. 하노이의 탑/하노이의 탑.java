import java.util.*;
class Solution {
    static List<int[]>list = new ArrayList<>();
    static void hanoi(int start,int mid,int end,int idx){
        if(idx==1){
            move(start,end,idx);
            return;
        }
        hanoi(start,end,mid,idx-1);
        move(start,end,idx);
        hanoi(mid,start,end,idx-1);
        
    }
    static void move(int start,int end,int idx){
        int [] arr = new int [2];
        arr[0]=start;
        arr[1]=end;
        list.add(arr);
    }
    public int[][] solution(int n) {
        hanoi(1,2,3,n);
        int[][] answer = new int[list.size()][2];
        for(int i=0;i<list.size();i++){
            answer[i]=list.get(i);
        }
        return answer;
    }
}