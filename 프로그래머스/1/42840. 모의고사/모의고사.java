import java.util.*;
import java.math.*;
class Solution {
    public int[] solution(int[] answers) {
        int [] first = {1,2,3,4,5};
        int [] second = {2,1,2,3,2,4,2,5};
        int [] third = {3,3,1,1,2,2,4,4,5,5};
        int [] arr =new int [3];
        int m=0;
        List<Integer>list = new ArrayList<>();
        int idx=0;
        int idx1=0;
        int idx2=0;
        int idx3=0;
        while(idx<answers.length){
            if(first[idx1]==answers[idx]){
                ++arr[0];
            }
            if(second[idx2]==answers[idx]){
                ++arr[1];
            }
            if(third[idx3]==answers[idx]){
                ++arr[2];
            }
            ++idx;
            ++idx1;
            ++idx2;
            ++idx3;
            if(idx1>=first.length){
                idx1=0;
            }
            if(idx2>=second.length){
                idx2=0;
            }
            if(idx3>=third.length){
                idx3=0;
            }
        }
        m= Math.max(arr[0],arr[1]);
        m= Math.max(m,arr[2]);
        for(int i=0;i<3;i++){
            if(arr[i]==m){
             list.add(i+1)   ;
            }
        }
        
        int[] answer = new int[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i]=list.get(i);
        }
        return answer;
    }
}