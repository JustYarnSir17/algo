import java.util.*;

class Solution {
    static int num=0;
    public int solution(int[] arr) {
        int answer = 0;
        int idx=2;
        
        if(arr[0]>arr[1]){
            cal(arr[0],arr[1]);
        }
        else{
            cal(arr[1],arr[0]);
        }
        while(idx<arr.length){
            if(num>arr[idx]){
                cal(num,arr[idx]);
            }
            else{
                cal(arr[idx],num);
            }
            
            ++idx;
        }
        answer= num;
        return answer;
    }
    public void cal(int a, int b){
        int n=a;
        int m=b;
        int gcd=0;
        
        while(m!=0){
            int tmp = n%m;
            if(tmp ==0){
                gcd= m;
                break;
            }
            n=m;
            m=tmp;
        }
        
        num=(a*b)/gcd;
        
    }
}